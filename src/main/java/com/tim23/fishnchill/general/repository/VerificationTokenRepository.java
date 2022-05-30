package com.tim23.fishnchill.general.repository;

import com.tim23.fishnchill.general.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    List<VerificationToken> findByToken(String token);
}
