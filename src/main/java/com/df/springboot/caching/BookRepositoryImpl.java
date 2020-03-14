package com.df.springboot.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.df.springboot.Book;

@Component
public class BookRepositoryImpl implements BookRepository {

	@Override
	@Cacheable("books")	// doesnt implement any caching library, its a simple fallback that uses ConcurrentHashMap
	public Book getBookByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "Java Book");
	}

	private void simulateSlowService() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	@Override
//    @Cacheable(cacheNames = "usercache",key = "#root.methodName") 	//use method name as key for this cache
//    public UserPayload firstUser() {
//        LOGGER.info("fetching firstUser");
//        return payloadUsers.get(0);
//    }
//    @Override
//    @Cacheable(cacheNames = "usercache",key = "{#firstName,#lastName}")	// use combination of first and lastname as key for this cache
//    public UserPayload userByFirstNameAndLastName(String firstName,String lastName) {
//        LOGGER.info("fetching user by firstname and lastname");
//        Optional<UserPayload> user = payloadUsers.stream().filter(
//                p-> p.getFirstName().equals(firstName)
//                &&p.getLastName().equals(lastName))
//                .findFirst();
//        if(user.isPresent()) {
//            return user.get();
//        } else {
//            return null;
//        }
//    }

}
