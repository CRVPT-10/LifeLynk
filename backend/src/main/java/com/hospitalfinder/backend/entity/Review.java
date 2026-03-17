package com.hospitalfinder.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private Integer rating;

    private String comment;

    private LocalDateTime createdAt;

    // Relations stored as IDs to keep it lightweight and flexible
    private String userId;

    private String hospitalId;

    private String doctorId;
}
