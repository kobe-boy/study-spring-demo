package com.aop;

import org.springframework.stereotype.Component;

@Component
public class Arithmetic {

	public int add(int i)throws Exception{
		System.out.println("add running...");
		//int b = i/0;
		return i+1;
	}
}
