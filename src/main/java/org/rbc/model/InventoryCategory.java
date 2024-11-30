package org.rbc.model;

import lombok.Getter;

@Getter
public enum InventoryCategory {

    BADMINTON_RACKETS("Badminton Rackets"),
    BADMINTON_SHUTTELS("Shuttles"),
    BADMINTON_SHOES("Shoes"),
    BADMINTON_STRING("String"),
    BADMINTON_GRIPS("Grip");

    private String name;

    private InventoryCategory(String name) {
        this.name = name;
    }


}
