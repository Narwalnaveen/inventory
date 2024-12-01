package org.rbc.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InventoryRequest implements Serializable {

    private int quantity;

    private boolean isAvailable;

    private int productId;
}
