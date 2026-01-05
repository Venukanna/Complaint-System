package com.cts.complaintsystem.dto;


import lombok.*;

@Data
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
}
