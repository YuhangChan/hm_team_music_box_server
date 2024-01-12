package org.sleepy.hmmusicbox.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class AllKeysConfig {
    @Bean
    CacheManager cacheManager() {
        return new CaffeineCacheManager();
    }

}
