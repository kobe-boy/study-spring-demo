package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopTest {

	/**
	 * 1.引入spring-aspects jar包
	 * 2.在配置文件中配置<aop:aspectj-autoproxy>标签表示自动为匹配的类前生成代理对象
	 * 3.写切面，写通知
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans-aop.xml");
		Arithmetic arithmetic = (Arithmetic)ac.getBean("arithmetic");
		int abc = arithmetic.add(9);
		System.out.println(abc);
	}
}
