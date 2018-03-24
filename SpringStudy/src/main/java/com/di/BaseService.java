package com.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	
	@Autowired
	private BaseRespository<T> respository;
	
	public void add(){
		System.out.println("add..."+respository);
		System.out.println(respository.query());
	}

}
