package com.df.springboot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@Profile("default-cache")
public class DefaultCacheData {
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Value("classpath:/users.json")
	private Resource usersJsonResource;
	
	@Bean
    public List<UserPayload> payloadUsers() throws IOException {
        try(InputStream inputStream = usersJsonResource.getInputStream()) {
            UserPayload[] payloadUsers = objectMapper.readValue(inputStream,UserPayload[].class);
            System.out.println("payload users size : " + payloadUsers.length);
            return Collections.unmodifiableList(Arrays.asList(payloadUsers));
        }
    }

}
