package com.hospitalfinder.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private Integer age;
    @Getter
    @Setter
    private String gender;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Role role;

    // For HOSPITAL role users - links to their owned hospital/clinic
    @Getter
    @Setter
    private String hospitalId;

    // For DOCTOR role users - links to their doctor profile
    @Getter
    @Setter
    private String doctorId;
}
