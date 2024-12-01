package org.rbc.service;

import org.rbc.domain.InventoryFilterRequest;
import org.rbc.domain.InventoryRequest;
import org.rbc.domain.InventoryResponse;
import org.rbc.model.Inventory;
import org.rbc.model.Product;
import org.rbc.repository.InventoryRepository;
import org.rbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation= Propagation.REQUIRED, readOnly=false)
    public String save(InventoryRequest inventoryRequest) throws Exception {
        Product product = productRepository.findById(inventoryRequest.getProductId()).orElseThrow(() -> new Exception("Product Not found"));
        Inventory inventory = new Inventory();
        inventory.setCreatedDate(new Date(System.currentTimeMillis()));
        inventory.setProduct(product);
        inventory.setQuantity(inventoryRequest.getQuantity());
        inventory.setAvailable(inventoryRequest.isAvailable());
        inventoryRepository.save(inventory);
        return "Inventory Updated";
    }

    public List<InventoryResponse> getInventories(InventoryFilterRequest inventoryFilterRequest) {
        List<Product> products =  productRepository.findAllByCompany(inventoryFilterRequest.getCompany());
        List<InventoryResponse> inventoryResponses = new ArrayList<>();
        for(Inventory inventory : inventoryRepository.findAllByProductIn(products)) {
            InventoryResponse inventoryResponse = new InventoryResponse();
            inventoryResponse.setInventoryCategory(inventory.getProduct().getInventoryCategory());
            inventoryResponse.setCompany(inventory.getProduct().getCompany());
            inventoryResponse.setAvailable(inventory.isAvailable());
            inventoryResponse.setProductName(inventory.getProduct().getProductName());
            inventoryResponse.setQuantity(inventory.getQuantity());
            inventoryResponse.setSalesPrice(inventory.getProduct().getSalesPrice());
            inventoryResponse.setPurchasePrice(inventory.getProduct().getPurchasePrice());
            inventoryResponses.add(inventoryResponse);
        }
        return inventoryResponses;
    }
}
