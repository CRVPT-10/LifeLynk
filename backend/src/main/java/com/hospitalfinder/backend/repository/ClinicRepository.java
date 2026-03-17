package com.hospitalfinder.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospitalfinder.backend.entity.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, String> {

    List<Clinic> findByCityIgnoreCase(String city);

    @Query("SELECT c FROM Clinic c JOIN c.specializations s WHERE LOWER(c.city) = LOWER(:city) AND LOWER(s.specialization) = LOWER(:specialization)")
    List<Clinic> findByCityAndSpecialization(@Param("city") String city,
            @Param("specialization") String specialization);

    @Query("SELECT c FROM Clinic c JOIN c.specializations s WHERE LOWER(s.specialization) = LOWER(:specialization)")
    List<Clinic> findBySpecialization(@Param("specialization") String specialization);

    boolean existsByNameIgnoreCaseAndAddressIgnoreCaseAndCityIgnoreCase(String name, String address, String city);

    boolean existsByName(String name);

    // Custom geospatial queries - will be implemented in service
    // For MongoDB geospatial queries, use 2dsphere index and Query annotations
    // Custom geospatial queries - simplified for now
    @Query("SELECT c FROM Clinic c")
    List<Clinic> findAllClinicsOrderedByDistance(Double latitude, Double longitude);

    @Query("SELECT c FROM Clinic c")
    List<Clinic> findNearestClinics(Double latitude, Double longitude);

    @Query("SELECT c FROM Clinic c LEFT JOIN FETCH c.specializations")
    List<Clinic> findAllWithSpecializations();

    @Query("SELECT DISTINCT c.city FROM Clinic c")
    List<String> findAllDistinctCities();

    @Query("SELECT DISTINCT c FROM Clinic c JOIN c.specializations s WHERE s.specialization IN :specializations")
    List<Clinic> findBySpecializationsIn(@Param("specializations") List<String> specializations);

    // Find clinic by owner ID
    Clinic findByOwnerId(String ownerId);
}