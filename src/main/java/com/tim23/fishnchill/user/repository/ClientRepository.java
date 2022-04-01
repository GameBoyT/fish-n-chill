package com.tim23.fishnchill.user.repository;

import com.tim23.fishnchill.user.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
