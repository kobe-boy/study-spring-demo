package com.hello.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans-hello.xml");
		Hello bean = ac.getBean(Hello.class);
		String say = bean.say("搞事情");
		System.out.println(say);
	}
}
