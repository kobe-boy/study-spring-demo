package com.di;

import org.springframework.stereotype.Repository;

@Repository
public class UserRespository extends BaseRespository<User> {

	@Override
	public String query() {
		return "UserRespository hello";
	}
}
