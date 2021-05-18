package xin.altitude.mutisourcecache.config;

import com.google.common.collect.Maps;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.util.CollectionUtils;
import xin.altitude.mutisourcecache.constants.CacheNameTimeConstant;

import java.time.Duration;
import java.util.Map;

/**
 * @Author explore
 * @Date 2021/05/18 21:37
 **/
@Configuration
public class MitiSourceCacheConfig {
    
    private final RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
            //变双冒号为单冒号
            .computePrefixWith(name -> name + ":")
            // 将Value序列化成JSON串
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    
    @Bean
    @Primary
    public CacheManager redisCacheManager(LettuceConnectionFactory factory) {
        // 全局配置默认一天
        RedisCacheConfiguration redisCacheConfiguration = config.entryTtl(Duration.ofHours(1));
        RedisCacheManager manager = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(factory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                // 初始化不同CACHENAME的过期过期时间
                .withInitialCacheConfigurations(initialCacheConfigurations())
                .build();
        return manager;
    }
    
    /**
     * 不同CacheName配置
     */
    private Map<String, RedisCacheConfiguration> initialCacheConfigurations() {
        Map<String, RedisCacheConfiguration> hashMap = Maps.newHashMap();
        hashMap.put(CacheNameTimeConstant.DEFAULT, config.entryTtl(Duration.ofDays(1)));
        hashMap.put(CacheNameTimeConstant.CACHE_1MINS, config.entryTtl(Duration.ofMinutes(1)));
        hashMap.put(CacheNameTimeConstant.CACHE_3MINS, config.entryTtl(Duration.ofMinutes(3)));
        hashMap.put(CacheNameTimeConstant.CACHE_5MINS, config.entryTtl(Duration.ofMinutes(5)));
        hashMap.put(CacheNameTimeConstant.CACHE_10MINS, config.entryTtl(Duration.ofMinutes(10)));
        hashMap.put(CacheNameTimeConstant.CACHE_15MINS, config.entryTtl(Duration.ofMinutes(15)));
        hashMap.put(CacheNameTimeConstant.CACHE_30MINS, config.entryTtl(Duration.ofMinutes(30)));
        return hashMap;
    }
    
    /**
     * 自定义key值生成规则
     *
     * @return
     */
    @Bean
    @Primary
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> String.format("%s:%s(%s)", target.getClass().getName(), method.getName(),
                CollectionUtils.arrayToList(params));
    }
    
    
    @Bean
    public CacheManager ehCacheManager() {
        return new EhCacheCacheManager();
    }
    
    @Bean
    public CacheManager redisCacheManager2(LettuceConnectionFactory factory) {
        RedisStandaloneConfiguration configuration = factory.getStandaloneConfiguration();
        configuration.setDatabase(9);
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(configuration);
        lettuceConnectionFactory.afterPropertiesSet();
        
        // 全局配置默认一天
        RedisCacheConfiguration redisCacheConfiguration = config.entryTtl(Duration.ofHours(1));
        RedisCacheManager manager = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(lettuceConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                // 初始化不同CACHENAME的过期过期时间
                .withInitialCacheConfigurations(initialCacheConfigurations())
                .build();
        return manager;
    }
}
