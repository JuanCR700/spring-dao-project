package com.springdao.demo.spring_dao_project.service;

import com.springdao.demo.spring_dao_project.dao.CustomerDAO;
import com.springdao.demo.spring_dao_project.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO dao;

    public CustomerService(CustomerDAO dao) {
        this.dao = dao;
    }

    @Transactional
    public Customer create(Customer c) {
        dao.save(c);
        return c;
    }

    @Transactional
    public Customer update(int id, Customer c){
        c.setId(id);
        dao.update(c);
        return c;
    }

    @Transactional
    public void delete(int id){
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    public Customer get(int id){
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Customer> getAll(){
        return dao.findAll();
    }
}
