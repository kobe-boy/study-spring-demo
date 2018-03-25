package com.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxText {

	/**
	 * 注解事务用法：
	 * 1.在配置文件中配置事务管理器，启用事务
	 * 2.在相应的方法上添加事务注解
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-tx.xml");
		DeptDao dao = ac.getBean(DeptDao.class);
		dao.updateDao3(3,"张三",2,"李四");
	}
}
