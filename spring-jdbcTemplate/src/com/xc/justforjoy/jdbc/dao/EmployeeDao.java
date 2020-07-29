package com.xc.justforjoy.jdbc.dao;

import com.xc.justforjoy.jdbc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    public Employee get(Integer id) {
        String sql = "select id,last_name lastName,email from employees where id=?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return emp;
    }

}

