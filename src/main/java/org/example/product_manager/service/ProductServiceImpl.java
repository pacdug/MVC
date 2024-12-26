package org.example.product_manager.service;

import org.example.product_manager.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {
        // Sample data
        products.add(new Product(1, "Laptop", 1200.50, "High-performance laptop", "Dell"));
        products.add(new Product(2, "Smartphone", 800.00, "Latest smartphone model", "Samsung"));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product existingProduct = getProductById(product.getId());
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}

