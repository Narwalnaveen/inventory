package org.rbc.repository;

import org.rbc.model.Company;
import org.rbc.model.InventoryCategory;
import org.rbc.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAllByCompany(Company company);

    List<Product> findAllByInventoryCategory(InventoryCategory inventoryCategory);
}
