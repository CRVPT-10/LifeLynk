package com.hospitalfinder.backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clinics")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;

    // Owner of this hospital (User with HOSPITAL role)
    @Getter
    @Setter
    private String ownerId;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String state;
    @Getter
    @Setter
    private String pincode;
    @Getter
    @Setter
    private Double latitude;
    @Getter
    @Setter
    private Double longitude;
    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "clinic_specializations",
        joinColumns = @JoinColumn(name = "clinic_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "specialization_id", referencedColumnName = "id")
    )
    private java.util.Set<Specialization> specializations = new java.util.HashSet<>();
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String website;
    @Getter
    @Setter
    private String timings;
    @Getter
    @Setter
    private Double rating;
    @Getter
    @Setter
    private Integer reviews;
    @Getter
    @Setter
    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Doctor> doctors = new ArrayList<>();
    @Getter
    @Setter
    private String imageUrl;
}