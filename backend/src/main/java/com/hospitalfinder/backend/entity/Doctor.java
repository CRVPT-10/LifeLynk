package com.hospitalfinder.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;
    @Getter @Setter
    private String qualification;
    @Getter @Setter
    private String specialization;
    @Getter @Setter
    private String experience;
    @Getter @Setter
    private String biography;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinic_id", insertable = false, updatable = false)
    @JsonIgnore
    private Clinic clinic;

    @Column(name = "clinic_id")
    @Getter @Setter
    private String clinicId;
    @Getter @Setter
    private String imageUrl;
}