package com.cts.complaintsystem.dto;


import lombok.*;

@Data
public class ComplaintRequest {
    private String title;
    private String category;
    private String description;
    private Long userId;
}

