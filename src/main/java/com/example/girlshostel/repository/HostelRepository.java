package com.example.girlshostel.repository;

import com.example.girlshostel.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HostelRepository extends JpaRepository<Hostel, Long> {

    // Custom query to find hostel by formNumber
    Optional<Hostel> findByFormNumber(String formNumber);
}
