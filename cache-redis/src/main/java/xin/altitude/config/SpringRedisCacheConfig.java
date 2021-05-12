package xin.altitude.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * SpringRedisCacheConfig
 * 全局配置文件中的配置会失效
 *
 * @Author explore
 * @Date 2021/05/12 12:19
 **/
@Configuration
public class SpringRedisCacheConfig {
    @Bean
    @Primary
    public CacheManager redisCacheManager(LettuceConnectionFactory factory) {
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(60))
                //变双冒号为单冒号
                .computePrefixWith(name -> name + ":")
                // 将Value序列化成JSON串
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheManager manager = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(factory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
        return manager;
    }
    
    @Bean
    public CacheManager redisCacheManagerDb02(LettuceConnectionFactory factory) {
        factory.setDatabase(2);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(60))
                //变双冒号为单冒号
                .computePrefixWith(name -> name + ":")
                // 将Value序列化成JSON串
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
        RedisCacheManager manager = RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(factory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
        return manager;
    }
}