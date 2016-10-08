package com.tips.registration.repository;

import com.tips.registration.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author herasimau on 07.10.2016.
 */
public interface VerificationTokenRepository  extends JpaRepository<VerificationToken,Long> {

    Optional<VerificationToken> findByToken(String token);
}
