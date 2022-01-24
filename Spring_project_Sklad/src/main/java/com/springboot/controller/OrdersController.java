package com.springboot.controller;

import com.springboot.forms.OrdersForm;
import com.springboot.models.Customer;
import com.springboot.models.FilesInfo;
import com.springboot.models.Orders;
import com.springboot.models.Products;
import com.springboot.services.CustomerService;
import com.springboot.services.FileService;
import com.springboot.services.OrdersService;
import com.springboot.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class OrdersController {
    private final OrdersService ordersService;
    private final ProductsService productsService;
    private final CustomerService customerService;
    private final FileService fileService;

    @GetMapping("/orders")
    public String getOrdersPage(Model model) {
        List<Orders> orders = ordersService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }
    @PostMapping("/add_orders")
    public String addOrders(OrdersForm form) {
        ordersService.addOrders(form);
        return "redirect:/orders";
    }
    @PostMapping("/add_order")
    public String addOrders() {
        return "redirect:/orders/add_order";
    }

    @GetMapping("/orders/add_order")
    public String getOrdersAddPage(Model model, OrdersForm form) {
        List<Orders> orders = ordersService.getAllOrders();
        List<Products> products = productsService.getAllProducts();
        List<Customer> customers = customerService.getAllCustomers();
        List<FilesInfo> files = fileService.getAllFiles();
        model.addAttribute("files", files);
        model.addAttribute("customers", customers);
        model.addAttribute("products", products);
        model.addAttribute("orders", orders);
        return "add_order";
    }
}
