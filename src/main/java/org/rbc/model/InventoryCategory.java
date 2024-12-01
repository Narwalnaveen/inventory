package org.rbc.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum InventoryCategory {

    BADMINTON_RACKETS("Badminton Rackets"),
    BADMINTON_SHUTTELS("Shuttles"),
    BADMINTON_SHOES("Shoes"),
    BADMINTON_STRING("String"),
    BADMINTON_GRIPS("Grip");

    private final String name;

    private InventoryCategory(String name) {
        this.name = name;
    }

    @JsonCreator
    public static InventoryCategory fromText(String text){
        for(InventoryCategory r : InventoryCategory.values()){
            if(r.getName().equals(text)){
                return r;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return name;
    }

}
