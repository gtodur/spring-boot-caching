package com.df.springboot.caching;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.df.springboot.UserPayload;

@Component
public class UserPayloadRepositoryImpl implements UserPayloadRepository {

//	@Override
//	@Cacheable("books")	// doesnt implement any caching library, its a simple fallback that uses ConcurrentHashMap
//	public Book getBookByIsbn(String isbn) {
//		simulateSlowService();
//		return new Book(isbn, "Java Book");
//	}
	
//	@Autowired
//	@Qualifier("payloadUsers")
//	private List<UserPayload> payloadUsersList;
	
	private List<UserPayload> getPayLoadUsers() {
		List<UserPayload> payloadUsers = new ArrayList<>();
		payloadUsers.add(new UserPayload("gurutodur", "Guru", "Todur"));
		payloadUsers.add(new UserPayload("geetashetti", "Geeta", "Shetti"));
		payloadUsers.add(new UserPayload("ganavitodur", "Ganavi", "Todur"));
		return payloadUsers;
	}
	
	private void simulateSlowService() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Cacheable(cacheNames = "userCache", key = "#root.methodName")
	public UserPayload getFirstUser() {
		System.out.println("Fetching first user by getFirstUser() API");
		simulateSlowService();
		return getPayLoadUsers().get(0);
	}

	@Override
	@Cacheable(cacheNames = "userCache", key = "{#firstname,#lastname}")
	public UserPayload getByFirstnameAndLastname(String firstname, String lastname) {
		System.out.println("Fetching user based on input firstname and lastname by getByFirstnameAndLastname() API");
		simulateSlowService();
		Optional<UserPayload> users = getPayLoadUsers().stream().filter(user -> user.getFirstName().equalsIgnoreCase(firstname)
				 && user.getLastName().equalsIgnoreCase(lastname)).findFirst();
		return users.isPresent() ? users.get() : null;
	}
}
