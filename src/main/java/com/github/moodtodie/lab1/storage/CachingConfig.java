package com.github.moodtodie.lab1.storage;

import com.github.moodtodie.lab1.entities.Fibonacci;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class CachingConfig {

    private final Map<Integer, Fibonacci> cache = new HashMap<>();

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("addresses");
    }

    public void add(int index){
        cache.put(index, new Fibonacci(Integer.toString(index)));
    }

    public boolean exist (int index){
        return cache.containsKey(index);
    }

    public Fibonacci get(int index){
        return cache.get(index);
    }
}
