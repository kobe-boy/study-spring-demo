package com.data;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Person {

	private String username;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date   birthday;
	@NumberFormat(pattern="#,###,###.#")
	private Float  salary; 

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "Person [username=" + username + ", birthday=" +sdf.format(birthday) + ", salary=" + salary + "]";
	}

	
	
	
	
}
