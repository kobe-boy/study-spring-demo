package com.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	/**
	 * 泛型依赖注入：
	 * spring4.x后，可以为子类注入子类对应的泛型类型的成员变量引用
	 * 因为BaseService和BaseRespository的引用关系，
	 * 继承它们的UserService和UserRespository会自动的建立引用关系
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans-di.xml");
		UserService userService = (UserService)ac.getBean("userService");
		userService.add();
	}
}
