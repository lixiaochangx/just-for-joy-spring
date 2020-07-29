package com.xc.justforjoy.jdbc;

import com.xc.justforjoy.jdbc.dao.DepartmentDao;
import com.xc.justforjoy.jdbc.dao.EmployeeDao;
import com.xc.justforjoy.jdbc.entity.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lxcecho
 * @since 2020/7/26
 */
public class JdbcTest {

    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;
    private EmployeeDao employeeDao = null;
    private DepartmentDao departmentDao = null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        employeeDao = ctx.getBean(EmployeeDao.class);
        departmentDao = ctx.getBean(DepartmentDao.class);
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);

    }

    /**
     * 使用具名参数时，可以使用update(String sql, SqlParameterSource paramSource)方法进行更新操作；
     * 1.SQL语句中的参数名和类的属性一致；
     * 2.使用SqlParameterSource的BeanPropertySqlParameterSource实现类作为参数；
     *
     */
    @Test
    public void testNamedParameterJdbcTemplate2() {
        String sql = "insert into employees(last_name,email,dept_id)" + " values(:lastName,:email,:deptid)";
        Employee emp = new Employee();
        emp.setLastName("xyz");
        emp.setEmail("xyz@163.com");
        emp.setDeptId(2);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(emp);

        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    /**
     * 可以为参数起名字， 1.好处：若有多个参数则不用再去对应位置，直接对应参数名，便于维护； 2.缺点：较为麻烦。
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "insert into employees(last_name,email,dept_id) values(:ln,:email,:deptid)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ln", "FF");
        paramMap.put("email", "ff@163.com");
        paramMap.put("deptid", "2");
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    @Test
    public void testDepartmentDao() {
        System.out.println(departmentDao.get(3));
    }

    @Test
    public void testEmployeeDao() {
        System.out.println(employeeDao.get(23));
    }

    /**
     * 获取单个列的值，或做统计查询;
     * 使用queryForObject(String sql, Class<Long> requiredType)方法。
     */
    @Test
    public void testQueryForObject2() {

        String sql = "select count(1) from employees";
        long count = jdbcTemplate.queryForObject(sql, Long.class);

        System.out.println(count);

    }

    // 查到实体类的集合:注意调用的不是queryForList方法
    @Test
    public void testQueryForList() {

        String sql = "select id,last_name lastName,email from employees where id > ?";

        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);

        List<Employee> emps = jdbcTemplate.query(sql, rowMapper, 12);

        System.out.println(emps);

    }

    // 从数据库中获取一条数据，实际得到对应的一个对象。
    /**
     * 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object...
     * args)方法； 而是调用 queryForObject(String sql, RowMapper<Employee> rowMapper,
     * Object... args)方法； 1.其中的RowMapper 指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper;
     * 2.使用SQL中的列名的别名完成列名和类的属性名的映射，例如last_name lastName
     * 3.不支持级联属性，JdbcTemplate到底是一个Jdbc的小工具，而不是ORM框架；
     */
    @Test
    public void testQueryForObject() {
        // 使用别名实现和Bean的映射对应
        String sql = "select id,last_name lastName,email,dept_id as \"department.id\" from employees where id=?";
        // Employee emp = jdbcTemplate.queryForObject(sql, Employee.class,1);

        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee emp = jdbcTemplate.queryForObject(sql, rowMapper, 12);
        System.out.println(emp);

    }

    // 批量更新:批量insert update delete
    // 最后一个参数是Object[]的List类型，因为修改一条记录需要一个Object的数组，
    // 那么多条不就需要多个Object的数组吗？(集合解决)
    @Test
    public void testBatch() {

        String sql = "insert into employees(last_name,email,dept_id) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[] { "aa", "aa@163.com", 1 });
        batchArgs.add(new Object[] { "bb", "bb@163.com", 1 });
        batchArgs.add(new Object[] { "cc", "cc@163.com", 2 });
        batchArgs.add(new Object[] { "dd", "dd@163.com", 2 });
        batchArgs.add(new Object[] { "ee", "ee@163.com", 1 });

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /**
     * 执行Insert update delete
     */
    @Test
    public void testUpdate() {

        String sql = "update employees set last_name=? where id=?";
        jdbcTemplate.update(sql, "Kitty", 5);

    }

    @Test
    public void test() throws Exception {
        DataSource dataSource = ctx.getBean(DataSource.class);

        System.out.println(dataSource.getConnection());

    }

}
