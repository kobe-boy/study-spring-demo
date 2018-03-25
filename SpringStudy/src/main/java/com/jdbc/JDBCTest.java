package com.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCTest {

	private  ApplicationContext ac= null;
	private	 JdbcTemplate       jdbcTemplate = null; 
	
	{
		ac = new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
		jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
	}
	
	/**
	 * 测试是否可以获取数据库连接
	 * @throws Exception
	 */
	@Test
	public void testJdbc() throws Exception{
		DataSource dataSource = (DataSource)ac.getBean("dataSource");
		System.out.println("测试链接:"+dataSource.getConnection());
	}
	
	/**
	 * 执行update、insert、delete
	 */
	@Test
	public void update(){
		String sql = "update tb01_employee set last_name= ? where id= ?";
		int count = jdbcTemplate.update(sql, "百事可乐",1);
		System.out.println("update 影响行数："+count);
	}
	
	/**
	 * 批量更新操作
	 */
	@Test
	public void updateBatch(){
		String sql = "insert into tb01_employee(id,last_name,email,gender,d_id) values(?,?,?,?,?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[]{3,"A1","a@com","aaabc",1});
		list.add(new Object[]{4,"B1","b@com","abbbc",2});
		list.add(new Object[]{5,"C1","c@com","abccc",2});
		int[] count = jdbcTemplate.batchUpdate(sql, list);
		System.out.println("update 影响行数："+Arrays.asList(count));
	}
	
	/**
	 * 查询
	 * 从数据库中获取一条记录，实际上是一个对象
	 * 注意调用的不是queryForObject(String, Class, Object)方法 
	 * 而是queryForObject(sql, rowMapper,args)
	 * 1.其中RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
	 * 2.使用sql中的别名完成列名和对象字段的映射，例如last_Name lastName
	 * 3.不支持级联属性，JdbcTemplate到底是一个JDBC的小工具，不是orm框架
	 */
	@Test
	public void queryEmployee(){
		String sql = "select id,last_name lastName,email,gender from tb01_employee where id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		System.out.println(employee.toString());
	}
	
	/**
	 * 查询实体类的集合
	 * 注意调用的不是querylist方法
	 */
	@Test
	public void queryEmployeeList(){
		String sql = "select id,last_name lastName,email,gender from tb01_employee where id > ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		List<Employee> list= jdbcTemplate.query(sql, rowMapper, 1);
		System.out.println(list.toString());
	}
	
	/*
	 * 查询单个列的值，或统计查询
	 * 使用queryForObject(String sql, Class<Long> requiredType)
	 */
	@Test
	public void queryforObject2(){
		String sql = "select count(id) from tb01_employee";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println("总数量:"+count);
	}
	
	/**
	 * 实际开发中使用测试
	 */
	@Test
	public void test(){
		EmployeeDao dao = ac.getBean(EmployeeDao.class);
		Employee employee = dao.get(1);
		System.out.println(employee);
	}
	
}
