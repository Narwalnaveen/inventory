package org.rbc.controller;

import org.rbc.domain.InventoryFilterRequest;
import org.rbc.domain.InventoryRequest;
import org.rbc.domain.InventoryResponse;
import org.rbc.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/saveInventory")
    public String saveInventory(@RequestBody InventoryRequest inventoryRequest) throws Exception {
        return inventoryService.save(inventoryRequest);
    }

    @PostMapping("/inventories")
    public List<InventoryResponse> getInventories(@RequestBody InventoryFilterRequest inventoryFilterRequest) {
        return inventoryService.getInventories(inventoryFilterRequest);
    }
}
