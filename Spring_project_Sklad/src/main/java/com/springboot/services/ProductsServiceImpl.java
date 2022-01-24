package com.springboot.services;

import com.springboot.forms.ProductsForm;
import com.springboot.models.Products;
import com.springboot.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProducts(ProductsForm form) {
        Products products = Products.builder()
                .description(form.getDescription())
                .price(form.getPrice())
                .count(form.getCount())
                .build();
        productRepository.save(products);
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Products getProduct(Integer productId) {
        return productRepository.getById(productId);
    }

    @Override
    public void updateProduct(Integer productId, ProductsForm productsForm) {
        Products product = productRepository.getById(productId);
        product.setDescription(productsForm.getDescription());
        product.setPrice(productsForm.getPrice());
        product.setCount(productsForm.getCount());
        productRepository.save(product);
    }
}
