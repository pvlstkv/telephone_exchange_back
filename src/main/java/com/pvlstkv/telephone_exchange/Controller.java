package com.pvlstkv.telephone_exchange;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController

public class Controller {


    @GetMapping("/hello")
    @Secured("USER")
    public String hello(HttpServletRequest request){
        return "hello " + request.getUserPrincipal().getName();
    }

    @GetMapping("/exception")
    @Secured("USER")
    public String exception(){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "exception text");
//        return "exception";
    }

}
