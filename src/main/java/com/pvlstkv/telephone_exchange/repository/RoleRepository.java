package com.pvlstkv.telephone_exchange.repository;

import com.pvlstkv.telephone_exchange.ERole;
import com.pvlstkv.telephone_exchange.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

}
