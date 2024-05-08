package com.example.projectbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TransportDTO {
    private  int id;
    private String name;
    private String notes;
    private String createdDate;
    private String updatedDate;
    private int isactive;
}
