package org.rbc.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private InventoryCategory inventoryCategory;

    @Enumerated(EnumType.STRING)
    private Company company;

    private double unitPrice;

    private String productName;

    private String productDescription;
}
