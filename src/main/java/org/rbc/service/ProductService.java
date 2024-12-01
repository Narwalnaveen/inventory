package org.rbc.service;

import org.rbc.domain.ProductRequest;

import org.rbc.model.Product;
import org.rbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation= Propagation.REQUIRED, readOnly=false)
    public String save(ProductRequest productRequest) throws Exception {
        Product product = new Product();
        product.setCompany(productRequest.getCompany());
        product.setInventoryCategory(productRequest.getInventoryCategory());
        product.setPurchasePrice(productRequest.getPurchasePrice());
        product.setSalesPrice(productRequest.getSalesPrice());
        product.setProductName(productRequest.getProductName());
        product.setProductDescription(productRequest.getProductDescription());
        productRepository.save(product);
        return "Product Saved";
    }
}
