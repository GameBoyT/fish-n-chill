package com.tim23.fishnchill.cottage;

import com.tim23.fishnchill.cottage.model.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageRepository extends JpaRepository<Cottage, Long> {
}
