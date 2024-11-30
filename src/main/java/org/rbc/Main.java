package org.rbc;

import jakarta.transaction.Transactional;
import org.rbc.model.Company;
import org.rbc.model.InventoryCategory;
import org.rbc.model.Product;
import org.rbc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
    }

    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setCompany(Company.YONEX);
        product.setInventoryCategory(InventoryCategory.BADMINTON_RACKETS);
        product.setUnitPrice(149.99);
        product.setProductName("Astrox 88S PRO");
        product.setProductDescription("Yonex Astrox 88S PRO - Doubles Specialized");

        productRepository.save(product);
    }
}