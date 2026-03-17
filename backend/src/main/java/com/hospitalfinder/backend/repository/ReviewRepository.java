package com.hospitalfinder.backend.repository;

import com.hospitalfinder.backend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {
    List<Review> findByHospitalId(String hospitalId);

    List<Review> findByDoctorId(String doctorId);

    List<Review> findByUserId(String userId);

    Review findByUserIdAndDoctorId(String userId, String doctorId);
}
