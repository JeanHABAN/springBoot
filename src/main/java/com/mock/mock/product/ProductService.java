package com.mock.mock.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public Optional<Product> getProduct(Long id) {
        return productRepo.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepo.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
