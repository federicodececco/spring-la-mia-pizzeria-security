package org.spring_la_mia_pizzeria.repository;

import java.util.Optional;

import org.spring_la_mia_pizzeria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String Username);
}
