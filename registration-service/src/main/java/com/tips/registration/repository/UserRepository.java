package com.tips.registration.repository;

import com.tips.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author herasimau on 07.10.2016.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
