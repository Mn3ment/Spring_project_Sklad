package com.springboot.controller;
import com.springboot.forms.CustomerForm;
import com.springboot.models.Customer;
import com.springboot.models.Orders;
import com.springboot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customer")
    public String getCustomersPage(Model model) {
        List<Customer> customer = customerService.getAllCustomers();
        model.addAttribute("customer", customer);
        return "customer";
    }

    @GetMapping("/customer/{customer-id}")
    public String getCustomerPage(Model model, @PathVariable("customer-id") Integer customerId) {
        Customer customer = customerService.getCustomers(customerId);
        model.addAttribute("customer", customer);
        return "customer_id";
    }

    @PostMapping("/customer")
    public String addCustomers(CustomerForm form) {
        customerService.addCustomers(form);
        return "redirect:/customer";
    }

    @PostMapping("/customer/{customer-id}/delete")
    public String deleteCustomer(@PathVariable("customer-id") Integer customerId) {
        customerService.deleteCustomers(customerId);
        return "redirect:/customer";
    }

    @PostMapping("/customer/{customer-id}/update")
    public String update(@PathVariable("customer-id") Integer customerId, CustomerForm form) {
        customerService.updateCustomers(customerId, form);
        return "redirect:/customer";
    }

    @GetMapping("/customer/{customer-id}/orders")
        public String getOrdersByUser(Model model, @PathVariable("customer-id") Integer customerId){
        List<Orders> orders = customerService.getOrdersByCustomer(customerId);
        model.addAttribute("orders", orders);
        return "orders_by_user";
    }

    @PostMapping("/customer/{customer-id}/orders")
    public String getOrderByUser(Model model, @PathVariable("customer-id") Integer customerId){
        List<Orders> orders = customerService.getOrdersByCustomer(customerId);
        model.addAttribute("orders", orders);
        return "redirect:/customer/{customer-id}/orders";
    }
}
