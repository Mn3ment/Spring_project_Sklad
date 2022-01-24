//package com.innopolis.springboot.repositories.jdbc;
//
//import com.innopolis.springboot.forms.ProductsForm;
//import com.innopolis.springboot.models.Products;
//
//import java.util.List;
//
//public interface ProductRepository {
//    void save(Products product);
//
//    List<Products> findAll();
//
//    List<Products> findAllByPrice(double price);
//
//    //найти все товары по количеству заказов, в которых участвуют
//
//    List<Products> findAllByOrdersCount(int ordersCount);
//    void delete(Long id);
//
//    Products findById(Long productId);
//    void update(Long productId, Products product);
//}
