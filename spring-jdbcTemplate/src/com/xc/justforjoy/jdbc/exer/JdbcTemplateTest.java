package com.xc.justforjoy.jdbc.exer;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcTemplateTest {
	
	private ApplicationContext ctx = null;
	private JdbcTemplate jdbcTemplate = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	//测试数据库连接
	@Test
	public void testConnDB() {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
	}

	//使用JdbcTemplate对数据库进行更新：增删改（insert delete update）
	@Test
	public void testUpdate() {
		String sql = "update employees set last_name = ? where id = ?";
		jdbcTemplate.update(sql,"Echo",21);
	}
	
	//批量更新：批量insert delete update
	@Test
	public void testBatch() {
		String sql = "insert into employees (last_name,email,dept_id) values(?,?,?)";
		List<Object[]> batchArgs = new ArrayList<>();
		batchArgs.add(new Object[]{"zhangsan", "zhangsan@163.com", 2 });
		batchArgs.add(new Object[]{"songjiang", "songjiang@163.com", 1 });
		batchArgs.add(new Object[]{"wuyong", "wuyong@163.com", 1 });
		batchArgs.add(new Object[]{"lujunyi", "lujunyi@163.com", 1 });
		batchArgs.add(new Object[]{"likui", "likui@163.com", 2 });
		batchArgs.add(new Object[]{"linchong", "linchong@163.com", 2 });
		
		jdbcTemplate.batchUpdate(sql, batchArgs);
		
	}
	
	//从数据库中获取一条数据，实际获取到一个对象
	@Test
	public void testQueryForObject() {
		String sql="select id,last_name lastName,email,dept_id from employees where id = ?";
		//1.RowMapper指定如何去印社结果集的行，常用的实现类是BeanRowMapper
		//2.使用SQL中的列名别名去完成和类的属性的映射
		//3.不支持级联属性
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		
		Employee emp = jdbcTemplate.queryForObject(sql, rowMapper,21);
		System.out.println(emp);
		
	}
	
	//查到实体类的集合：注意调用的不是queryForList方法,用query方法
	@Test
	public void testQuery() {
		String sql = "select id,last_name lastName,email,dept_id from employees where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> emps = jdbcTemplate.query(sql, rowMapper,21);
		System.out.println(emps);
	}
	
	//获取单个列值，或作统计查询
	@Test 
	public void testQueryForObject2() {
		
		String sql = "select count(1) from employees";
		long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println("count = "+ count);
		
	}
	
}
