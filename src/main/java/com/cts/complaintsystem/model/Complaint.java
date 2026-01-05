package com.cts.complaintsystem.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String category;

    private String description;

    private String status = "Open";

    @ManyToOne
    private User user;
}
