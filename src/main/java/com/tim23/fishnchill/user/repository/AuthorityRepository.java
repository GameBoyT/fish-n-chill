package com.tim23.fishnchill.user.repository;

import com.tim23.fishnchill.user.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	Authority findByName(String name);
}
