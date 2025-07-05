package com.eng.transactionapp.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String createProduct(@RequestBody Product product) {
        try {
            productService.saveProduct(product);
            return "Product saved";
        } catch (Exception e) {
            return "Failed: " + e.getMessage();
        }
    }

    @PostMapping
    @RequestMapping("/all")
    public String createAllProduct() {
        try {
            productService.saveAllProduct();
            return "Product saved";
        } catch (Exception e) {
            return "Failed: " + e.getMessage();
        }
    }
}
