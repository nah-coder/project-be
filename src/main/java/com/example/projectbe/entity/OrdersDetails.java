package com.example.projectbe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "orders_details")
public class OrdersDetails {
    @Id
    @Column(name = "ID" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDORD")
    private Integer idord;

    @Column(name = "IDPRODUCT")
    private Integer idproduct;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QTY")
    private Integer qty;
}
