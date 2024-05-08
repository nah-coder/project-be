package com.example.projectbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustommerDTO {
    private int id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String email;
    private String phone;
    private String createdDate;
    private Byte isactive;

}
