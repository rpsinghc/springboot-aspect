package com.example.aspect;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author Ram Prakash Singh
 */

@Slf4j
@Configuration
@EnableCaching
@ConditionalOnClass({Caffeine.class, CaffeineCacheManager.class})
public class CaffeinePerCacheConfig {

    String CAFFIEN_SPEC = "spring.cache.caffeine.specs";

    @Bean
    CacheManagerCustomizer<CaffeineCacheManager> caffeinePerCacheCustomizer(ApplicationContext context) {
        return cacheManager -> {
            boolean found = context.getEnvironment().containsProperty(CAFFIEN_SPEC);
            if (found) {
                HashMap<String, String> hashMap = (HashMap<String, String>) Binder.get(context.getEnvironment()).bindOrCreate(CAFFIEN_SPEC, Bindable.mapOf(String.class, String.class));
                for (Entry<String, String> spec : hashMap.entrySet()) {
                    log.info("adding cache manager for '{}' spec",spec.getKey());
                    cacheManager.registerCustomCache(spec.getKey(), Caffeine.from(spec.getValue()).build());
                }
            }
        };
    }
}

