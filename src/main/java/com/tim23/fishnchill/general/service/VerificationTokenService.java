package com.tim23.fishnchill.general.service;

import com.tim23.fishnchill.general.model.VerificationToken;
import com.tim23.fishnchill.general.repository.VerificationTokenRepository;
import com.tim23.fishnchill.user.model.Client;
import com.tim23.fishnchill.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public void DeleteTokenByUser(User user){
        verificationTokenRepository.delete(verificationTokenRepository.findByUser(user));
    }

    public VerificationToken findByToken(String name){
        return verificationTokenRepository.findByToken(name);
    }

    public void save(VerificationToken verificationToken) {
        verificationTokenRepository.save(verificationToken);
    }
}

