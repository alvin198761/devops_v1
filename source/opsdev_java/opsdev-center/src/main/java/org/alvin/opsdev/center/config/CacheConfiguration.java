package org.alvin.opsdev.center.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tangzhichao on 2016/11/3.
 */
@Configuration
public class CacheConfiguration {


    @Bean(destroyMethod = "shutdown")
    public CacheManager ehCacheManager() {
        net.sf.ehcache.config.CacheConfiguration cacheConfiguration = new net.sf.ehcache.config.CacheConfiguration();
        cacheConfiguration.setName("EHCACHE_NAME");
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(10);
        cacheConfiguration.setTimeToIdleSeconds(60);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);

        return CacheManager.newInstance(config);
    }

    @Bean
    public org.springframework.cache.CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }
}
