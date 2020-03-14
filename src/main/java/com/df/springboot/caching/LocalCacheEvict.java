package com.df.springboot.caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default-cache")
public class LocalCacheEvict {
	
//	@CacheEvict(cacheNames = "alluserscache", allEntries = true)
//	public void evictAllUsersCache() {
//		
//	}

	@CacheEvict(cacheNames = "usercache", allEntries = true)
	public void evictUserCache() {
		
	}
}
