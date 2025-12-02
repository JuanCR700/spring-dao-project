package com.springdao.demo.spring_dao_project.controller;

import com.springdao.demo.spring_dao_project.model.Customer;
import com.springdao.demo.spring_dao_project.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> all(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable int id){
        return service.get(id);
    }

    @PostMapping
    public Customer create(@RequestBody Customer c){
        return service.create(c);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer c){
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
