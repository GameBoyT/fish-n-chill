package com.tim23.fishnchill.reservation.repository;

import com.tim23.fishnchill.reservation.model.CottageReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CottageReservationRepository extends JpaRepository<CottageReservation, Long> {
    List<CottageReservation> findAllByClientId(Long id);

    List<CottageReservation> findAllByCottageId(Long id);
}
