package com.springboot.services;

import com.springboot.forms.CustomerForm;
import com.springboot.models.Customer;
import com.springboot.models.Orders;


import java.util.List;

public interface CustomerService {

    void addCustomers(CustomerForm form);
    List<Customer> getAllCustomers();
    void deleteCustomers(Integer customerId);

    Customer getCustomers(Integer customerId);

    void updateCustomers(Integer customerId, CustomerForm form);
    List<Orders> getOrdersByCustomer(Integer customerId);
}
