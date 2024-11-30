package org.rbc.service;

import org.rbc.model.Inventory;
import org.rbc.model.Product;
import org.rbc.repository.InventoryRepository;
import org.rbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation= Propagation.REQUIRED, readOnly=false)
    public Inventory save() {
        Product product = productRepository.findById(1).get();
        Inventory inventory = new Inventory();
        inventory.setProduct(product);
        inventory.setQuantity(5);
        inventory.setAvailable(true);
        return inventoryRepository.save(inventory);
    }
}
