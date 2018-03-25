package com.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeptDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void updateDao1(int id,String depName){
		String sql = "insert into tb01_dept(id,dep_name) values(?,?)";
		int update = jdbcTemplate.update(sql,id,depName);
		System.out.println("插入"+update+"条");
	}
	
	public void updateDao2(int id,String depName){
		String sql = "update tb01_dept set dep_name=? where id=?";
		int update = jdbcTemplate.update(sql,depName,id);
		System.out.println("更新"+update+"条");
	}
	
	/**
	 * 1.事务的传播行为：
	 * 	使用propagation指定事务的传播行为，默认是REQUIRED。即使用调用方法的事务
	 * 	事务传播行为即当前事务被另外一个事务方法调用时如何使用事务
	 * 	REQUIRES_NEW是使用自己的事务，调用方法的事务被挂起
	 * 2.事务的隔离级别：
	 * 	使用isolation指定事务的隔离级别，最常用的是READ_COMMITTED读已提交
	 * 3.使用readOnly指定事务是否为只读，表示事务只读取不更新
	 * 	只读事务可以帮助数据库引擎优化事务。若真的是只读事务应设置readOnly=true
	 * 4.使用timeout指定强制回滚之前事务可以占用的时间。时间秒
	 */
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,timeout=1)
	public void updateDao3(int id1,String depName1,int id2,String depName2){
		updateDao1(id1,depName1);
		int i =1/0;
		updateDao2(id2,depName2);
	}
}
