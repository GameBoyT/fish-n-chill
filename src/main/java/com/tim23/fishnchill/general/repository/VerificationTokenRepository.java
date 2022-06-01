package com.tim23.fishnchill.general.repository;

import com.tim23.fishnchill.general.model.VerificationToken;
import com.tim23.fishnchill.user.model.Client;
import com.tim23.fishnchill.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);

    VerificationToken findByClient(Client client);
}
