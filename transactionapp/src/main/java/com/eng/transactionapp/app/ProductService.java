package com.eng.transactionapp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FirstProgrammaticApproach firstProgrammaticApproach;

    @Autowired
    SecondProgrammaticApproach secondProgrammaticApproach;

    @Transactional(transactionManager = "transactionManager")
    public void saveAllProduct() {
        for (int i = 1; i <= 10; i++) {
            Product product = new Product();
            product.setId((long) i);
            product.setName("Test Product " + i);
            productRepository.save(product);
            if(product.getId() == 7) {
                throw new RuntimeException("Exception occurred on ID: " + product.getId());
            }
        }
    }

    @Transactional
    public void saveProduct(Product product) {
        firstProgrammaticApproach.updateUser();
        secondProgrammaticApproach.updateUser();
        productRepository.save(product);

        // Example of triggering rollback
        if (product.getName().equalsIgnoreCase("fail")) {
            throw new RuntimeException("Simulated failure");
        }
    }
}
