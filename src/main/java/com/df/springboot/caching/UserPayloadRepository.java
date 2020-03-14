package com.df.springboot.caching;

import org.springframework.stereotype.Repository;

import com.df.springboot.UserPayload;

@Repository
public interface UserPayloadRepository {
	public UserPayload getFirstUser();
	
	public UserPayload getByFirstnameAndLastname(String firstname, String lastname);
}
