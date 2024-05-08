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
public class CategoryDTO {
    private int id;
    private int idparent;
    private String name;
    private String notes;
    private String icon;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
    private int isactive;


}
