package com.thankfulness.thankfulness.repository;

import com.thankfulness.thankfulness.model.ThankfulnessImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ThankfulnessImageRepository extends JpaRepository<ThankfulnessImage,Long> {

    @Query(value = "select imagePath from ThankfulnessImage where thankfulnessId = ?1")
    List<String> findImagesPathByThankfulnessId(UUID thankfulness_id);
}
