package com.hospitalfinder.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalfinder.backend.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
    // Find doctors by clinic and specialization
    List<Doctor> findByClinicIdAndSpecializationIgnoreCase(String clinicId, String specialization);

    // Find all doctors for a clinic
    List<Doctor> findByClinicId(String clinicId);
}