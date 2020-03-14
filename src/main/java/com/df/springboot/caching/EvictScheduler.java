package com.df.springboot.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile("default-cache")
public class EvictScheduler {
	
    @Autowired
    private LocalCacheEvict localCacheEvict;
    
    @Scheduled(fixedDelay=10000)
    public void clearCaches() {
        System.out.println("Invalidating caches");
        localCacheEvict.evictUserCache();
        //localCacheEvict.evictAllUsersCache();
    }
}
