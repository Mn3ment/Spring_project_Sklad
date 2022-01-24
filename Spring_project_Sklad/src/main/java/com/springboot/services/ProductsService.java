package com.springboot.services;

import com.springboot.forms.ProductsForm;
import com.springboot.models.Products;

import java.util.List;

public interface ProductsService {
    void addProducts(ProductsForm form);
    List<Products> getAllProducts();
    void deleteProduct(Integer productId);

    Products getProduct(Integer productId);

    void updateProduct(Integer productId, ProductsForm productsForm);

}
