package org.rbc.domain;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.rbc.model.Company;
import org.rbc.model.InventoryCategory;

import java.io.Serializable;

@Getter
@Setter
public class ProductRequest implements Serializable {

    @Enumerated(EnumType.STRING)
    private InventoryCategory inventoryCategory;

    @Enumerated(EnumType.STRING)
    private Company company;

    private double purchasePrice;

    private double salesPrice;

    private String productName;

    private String productDescription;
}
