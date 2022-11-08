package com.memorydao;

import com.dao.CustomerDAO;
import com.domain.Customer;

import java.util.HashMap;

public class CustomerDAOMemory implements CustomerDAO {

    protected static HashMap<String, Customer> entities = new HashMap<String, Customer>();


    @Override
    public void save(Customer customer) {
        entities.put(customer.getName(), customer);
    }

    @Override
    public boolean exists(String name) {
        return entities.containsKey(name);
    }

    @Override
    public Customer get(String name) {
        return entities.get(name);
    }


}
