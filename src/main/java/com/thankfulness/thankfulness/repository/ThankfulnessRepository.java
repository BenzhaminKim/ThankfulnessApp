package com.thankfulness.thankfulness.repository;

import com.thankfulness.thankfulness.model.Thankfulness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ThankfulnessRepository extends JpaRepository<Thankfulness,Long> {

    @Query(value = "Select * from Thankfulness where thankfulness_id = ?1", nativeQuery = true)
    Optional<Thankfulness> findByUUID(UUID id);

    @Query(value = "Select * from Thankfulness where user_id = ?1", nativeQuery = true)
    List<Thankfulness> findAllByUserId(UUID userId);
}
