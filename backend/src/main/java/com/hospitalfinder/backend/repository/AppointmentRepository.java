package com.hospitalfinder.backend.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospitalfinder.backend.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    Collection<Appointment> findByUserId(String userId);
    Collection<Appointment> findByClinicId(String clinicId);
    List<Appointment> findByUserIdAndStatusIgnoreCase(String userId, String status);
    List<Appointment> findByClinicIdAndStatusIgnoreCase(String clinicId, String status);
    List<Appointment> findByDoctorId(String doctorId);
    boolean existsByUserIdAndClinicIdAndAppointmentTime(String userId, String clinicId, LocalDateTime appointmentTime);
    // check if a slot is already taken for a doctor
    boolean existsByDoctorIdAndAppointmentTime(String doctorId, LocalDateTime appointmentTime);

    // get all booked slots of a doctor for a date
    @Query("SELECT a FROM Appointment a WHERE a.doctorId = :doctorId AND a.appointmentTime >= :startOfDay AND a.appointmentTime < :endOfDay")
    List<Appointment> findByDoctorAndDate(@Param("doctorId") String doctorId, @Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);
}
