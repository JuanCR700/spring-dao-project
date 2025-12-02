package com.springdao.demo.spring_dao_project.dao;

import com.springdao.demo.spring_dao_project.model.Customer;
import java.util.List;

public interface CustomerDAO {

    int save(Customer customer);

    int update(Customer customer);

    int delete(int id);

    Customer findById(int id);

    List<Customer> findAll();
}
