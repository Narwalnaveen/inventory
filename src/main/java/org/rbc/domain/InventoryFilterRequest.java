package org.rbc.domain;

import lombok.Getter;
import lombok.Setter;
import org.rbc.model.Company;
import org.rbc.model.InventoryCategory;

import java.io.Serializable;

@Getter
@Setter
public class InventoryFilterRequest implements Serializable {

    private InventoryCategory inventoryCategory;

    private Company company;
}
