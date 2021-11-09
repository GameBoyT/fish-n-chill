package com.tim23.fishnchill.general.repository;

import com.tim23.fishnchill.general.model.BaseEntity;
import com.tim23.fishnchill.cottage.model.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaseEntityRepository extends JpaRepository<BaseEntity, Long> {
//    @Query(value = "SELECT a FROM BaseEntity a WHERE a.id = ?1")
//    List<House> findHousesByName(Long EntityId);

    @Query(value = "SELECT a FROM Cottage a WHERE a.name = ?1")
    List<Cottage> findCottagesByName(String houseName);

}
