package com.tim23.fishnchill.reservation.repository;

import com.tim23.fishnchill.reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
