package com.df.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.df.springboot.caching.BookRepository;
import com.df.springboot.caching.UserPayloadRepository;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class SpringBootCachingApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootCachingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCachingApplication.class, args);
	}
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserPayloadRepository userPayloadRepository;

	@Override
	public void run(String... args) throws Exception {
		logger.info(".... Fetching books");
        logger.info("isbn-1234 -->" + bookRepository.getBookByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getBookByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getBookByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getBookByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getBookByIsbn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookRepository.getBookByIsbn("isbn-1234"));
        
        logger.info(".... fetching first user");
        logger.info("First user from json is --> " + userPayloadRepository.getFirstUser());
        logger.info("First user from json is --> " + userPayloadRepository.getFirstUser());
        logger.info("First user from json is --> " + userPayloadRepository.getFirstUser());
        logger.info("First user from json is --> " + userPayloadRepository.getFirstUser());
        
        
        logger.info(".... fetching by first name and lastname combination");
        logger.info("First user from json is --> " + userPayloadRepository.getByFirstnameAndLastname("Guru", "Todur"));
        logger.info("First user from json is --> " + userPayloadRepository.getByFirstnameAndLastname("Guru", "Todur"));
        logger.info("First user from json is --> " + userPayloadRepository.getByFirstnameAndLastname("Geeta", "Shetti"));
        logger.info("First user from json is --> " + userPayloadRepository.getByFirstnameAndLastname("Guru", "Todur"));
	}

}
