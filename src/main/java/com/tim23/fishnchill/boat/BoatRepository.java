package com.tim23.fishnchill.boat;

import com.tim23.fishnchill.boat.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatRepository extends JpaRepository<Boat, Long> {
}
