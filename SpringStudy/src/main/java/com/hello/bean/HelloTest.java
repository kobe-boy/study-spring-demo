package com.hello.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class HelloTest {

	/**
	 * helloword:
	 * 1.使用context:component-scan标签进行包扫描
	 * 2.在类上添加@Controller、@Service、@Repository，@Component注解
	 * 
	 * 引入外部配置文件：
	 * 1.使用context:property-placeholder标签
	 * 2.使用${var}填写值
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans-hello.xml");
		//测试包扫描，helloword
		Hello bean = ac.getBean(Hello.class);
		String say = bean.say("我爱你北京");
		System.out.println(say);
		//测试外部引入文件
		ComboPooledDataSource dataSource = (ComboPooledDataSource) ac.getBean("dataSource");
		System.out.println(dataSource.toString());
	}
}
