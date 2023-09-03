package com.kamar.inventory_management_system_cloud_native.components.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * an item entity.
 * @author kamar baraka.*/

@Entity
@Getter
@Setter
public class Stock {

    @Id
    @Column(unique = true)
    private String itemName;

    private String itemCode;

    private int itemCount;

    @OneToOne(cascade = {CascadeType.ALL})
    private ItemLocation location;

    private BigDecimal itemPrice;
}
