package com.example.projectbe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {
    private int id;
    private String idorder;
    private String ordersDate;
    private int idcustomer;
    private double totalMoney;
    private String notes;
    private String nameReciver;
    private String address;
    private String phone;
}
