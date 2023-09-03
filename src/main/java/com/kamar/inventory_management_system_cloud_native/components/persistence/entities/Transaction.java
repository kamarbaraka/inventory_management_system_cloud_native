package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * a bill entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionId;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Payment payment;


    private final LocalDateTime dateTime = LocalDateTime.now();

}
