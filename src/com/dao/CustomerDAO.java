package com.dao;


import com.domain.Customer;

public interface CustomerDAO {
    void save(Customer customer);

    boolean exists(String name);

    Customer get(String name);
}
