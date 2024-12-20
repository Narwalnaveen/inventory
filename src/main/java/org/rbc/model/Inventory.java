package org.rbc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Integer id;

    private int quantity;

    private boolean isAvailable;

    private Date createdDate;

    private Date lastUpdateDate;

    @OneToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return "Inventory{" +
                "quantity= " + quantity +
                ", isAvailable= " + isAvailable +
                ", product Name = " + product.getProductName() +
                ", product Description = " + product.getProductDescription()+
                '}';
    }
}
