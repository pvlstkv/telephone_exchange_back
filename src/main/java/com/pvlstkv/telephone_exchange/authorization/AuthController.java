package com.pvlstkv.telephone_exchange.authorization;

import com.pvlstkv.telephone_exchange.model.Subscriber;
import com.pvlstkv.telephone_exchange.repository.SubscriberRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    AuthenticationManager authenticationManager;

    SubscriberRepository subscriberRepository;
    PasswordEncoder encoder;

    JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, SubscriberRepository subscriberRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.subscriberRepository = subscriberRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Message authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

//        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtUtils.generateJwt(userDetails);
        return new Message(jwt);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (subscriberRepository.existsByName(signUpRequest.getLogin())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "имя пользователя " + signUpRequest.getLogin() + " уже занято");
        }

//        if (subscriberRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//        }

        // Create new user's account
        Subscriber subscriber = new Subscriber(signUpRequest.getLogin(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRoles();
        Set<ERole> roles = new HashSet<>();

        if (strRoles == null) {
            roles.add(ERole.USER);
        } else {
            strRoles.forEach(role -> {
                if (role.equals("admin")) {
                    roles.add(ERole.ADMIN);
                }
                if (role.equals("user")) {
                    roles.add(ERole.USER);
                }
            });
        }

        subscriber.setRoles(roles);
        subscriberRepository.save(subscriber);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

//    @PostMapping("/signout")
//    public ResponseEntity<?> logoutUser(HttpHeaders httpHeaders) {
//
//        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
//                .body(new MessageResponse("You've been signed out!"));
//    }
}