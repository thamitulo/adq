package com.ae.adq.maha.interview.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Inventory {

    @Id
    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double unitPrice;

    @Column(nullable = false)
    private double discountPercentage;

    @Column(nullable = false)
    private int discountUnits;
}

