package com.thankfulness.thankfulness.repository;

import com.thankfulness.thankfulness.model.Thankfulness;
import com.thankfulness.thankfulness.model.ThankfulnessUser;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ThankfulnessUserRepository extends JpaRepository<ThankfulnessUser,Long> {
    ThankfulnessUser findByUsername(String username);
}
