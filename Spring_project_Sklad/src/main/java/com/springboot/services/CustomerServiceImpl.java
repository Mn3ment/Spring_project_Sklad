package com.springboot.services;

import com.springboot.exceptions.CustomerNotFoundException;
import com.springboot.forms.CustomerForm;
import com.springboot.models.Customer;
import com.springboot.models.Orders;
import com.springboot.repositories.CustomersRepository;
import com.springboot.repositories.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CustomerServiceImpl implements CustomerService {
    private final CustomersRepository customersRepository;
    private final OrdersRepository ordersRepository;


    @Override
    public void addCustomers(CustomerForm form) {
        Customer customer = Customer.builder()
                .first_name(form.getFirst_name())
                .last_name(form.getLast_name())
                .address(form.getAddress())
                .build();
        customersRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public void deleteCustomers(Integer customerId) {
        customersRepository.deleteById(customerId);

    }

    @Override
    public Customer getCustomers(Integer customerId) {
        return customersRepository.findById(customerId)
                .orElseThrow(CustomerNotFoundException::new);
    }

    @Override
    public void updateCustomers(Integer customerId, CustomerForm form) {
        Customer customer = customersRepository.getById(customerId);
        customer.setFirst_name(form.getFirst_name());
        customer.setLast_name(form.getLast_name());
        customersRepository.save(customer);
    }

    @Override
    public List<Orders> getOrdersByCustomer(Integer customerId) {
        return ordersRepository.findAllByCustomer_Id(customerId);
    }
}
