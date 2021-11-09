package com.tim23.fishnchill.general.repository;

import com.tim23.fishnchill.general.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
