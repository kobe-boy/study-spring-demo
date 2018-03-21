package com.hello.bean;

import org.springframework.stereotype.Component;

@Component
public class Hello {
	private String name;
	private int    age;
	
	
	public Hello() {
		super();
		System.out.println("Hello³õÊ¼»¯");
	}

	public Hello(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String say(String song){
		return "³ª£º¡¶"+song+"¡·¸è";
	}
	
	
}
