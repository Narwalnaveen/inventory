package org.rbc.controller;

import org.rbc.model.Inventory;
import org.rbc.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/saveinventory")
    public Inventory saveInventory() {
        return inventoryService.save();
    }
}
