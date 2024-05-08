package com.example.projectbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private String notes;
    private String image;
    private int idcategory;
    private double price;
    private int quatity;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
    private String isactive;
}
