package com.springdao.demo.spring_dao_project.dao;

import com.springdao.demo.spring_dao_project.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Customer> mapper = (rs, rowNum) ->
            new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
            );

    @Override
    public int save(Customer c) {
        return jdbcTemplate.update(
                "INSERT INTO customer(name, email) VALUES (?, ?)",
                c.getName(),
                c.getEmail()
        );
    }

    @Override
    public int update(Customer c) {
        return jdbcTemplate.update(
                "UPDATE customer SET name=?, email=? WHERE id=?",
                c.getName(),
                c.getEmail(),
                c.getId()
        );
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM customer WHERE id=?", id);
    }

    @Override
    public Customer findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM customer WHERE id=?",
                mapper,
                id
        );
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query("SELECT * FROM customer", mapper);
    }
}
