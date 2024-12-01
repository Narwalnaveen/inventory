package org.rbc.repository;

import org.rbc.model.Inventory;
import org.rbc.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

    List<Inventory> findAllByProductIn(List<Product> product);
}
