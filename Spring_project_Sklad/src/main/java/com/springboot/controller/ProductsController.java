package com.springboot.controller;


import com.springboot.forms.ProductsForm;
import com.springboot.models.Products;
import com.springboot.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;

@Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String getProductsPage(Model model) {
        List<Products> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/products/{product-id}")
    public String getProductsPage(Model model, @PathVariable("product-id") Integer productId) {
        Products product = productsService.getProduct(productId);
        model.addAttribute("products", product);
        return "product";
    }

    @PostMapping("/products")
    public String addProducts(ProductsForm form) {
        productsService.addProducts(form);
        return "redirect:/products";
    }

    @PostMapping("/products/{product-id}/delete")
    public String deleteProduct(@PathVariable("product-id") Integer productId) {
        productsService.deleteProduct(productId);
        return "redirect:/products";
    }

    @PostMapping("/products/{product-id}/update")
    public String update(@PathVariable("product-id") Integer productId, ProductsForm form) {
        productsService.updateProduct(productId, form);
        return "redirect:/products";
    }
}
