package com.df.springboot.caching.hazelcast;

import org.springframework.context.annotation.Bean;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

public class HazelcastCacheConfig {
	
	@Bean
    public Config hazelCastConfig() {
 
        //Config config = new Config();
        //config.setInstanceName("hazelcast-cache");
 
//        MapConfig allUsersCache = new MapConfig();
//        allUsersCache.setTimeToLiveSeconds(20);
//        allUsersCache.setEvictionPolicy(EvictionPolicy.LFU);
//        config.getMapConfigs().put("alluserscache",allUsersCache);
 
//        MapConfig usercache = new MapConfig();
//        usercache.setTimeToLiveSeconds(20);
//        usercache.setEvictionPolicy(EvictionPolicy.LFU);
//        config.getMapConfigs().put("userhazelcache",usercache);
 
        //return config;
		return new Config().setInstanceName("hazelcast-cache")
                .addMapConfig(new MapConfig().setName("itemCache")
                .setMaxSizeConfig(new MaxSizeConfig(300,MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                .setEvictionPolicy(EvictionPolicy.LRU)
                .setTimeToLiveSeconds(2000));
        
    }
}
