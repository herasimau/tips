package com.tips.auth.repository;


import com.tips.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author herasimau on 07.10.2016.
 */

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
