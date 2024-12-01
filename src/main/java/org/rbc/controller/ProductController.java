package org.rbc.controller;

import org.rbc.domain.ProductRequest;
import org.rbc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public String saveInventory(@RequestBody ProductRequest productRequest) throws Exception {
        return productService.save(productRequest);
    }
}
