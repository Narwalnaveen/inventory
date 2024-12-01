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
public class InventoryResponse implements Serializable {

    private int quantity;

    private boolean isAvailable;

    private InventoryCategory inventoryCategory;

    private Company company;

    private double purchasePrice;

    private double salesPrice;

    private String productName;

    private String productDescription;
}
