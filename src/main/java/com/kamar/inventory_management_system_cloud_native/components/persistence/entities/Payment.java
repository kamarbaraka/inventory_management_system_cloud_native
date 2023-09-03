package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * a payment entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue
    private long paymentId;

    private String paymentType;

    private String bankName;

    private String accountName;

    private String mobileNumber;

    private BigDecimal paymentAmount;

}
