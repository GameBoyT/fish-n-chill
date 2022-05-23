package com.tim23.fishnchill.adventure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdventureRepository extends JpaRepository<Adventure, Long> {
    List<Adventure> findByNameContainingIgnoreCase(String name);
    List<Adventure> findByDescriptionContainingIgnoreCase(String description);
    List<Adventure> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

}
