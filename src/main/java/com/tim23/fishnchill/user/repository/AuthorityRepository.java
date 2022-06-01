package com.tim23.fishnchill.user.repository;

import com.tim23.fishnchill.user.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(String name);

    @Override
    List<Authority> findAll();

    List<Authority> findByNameContaining(String name);

    Authority getById(Long id);

}
