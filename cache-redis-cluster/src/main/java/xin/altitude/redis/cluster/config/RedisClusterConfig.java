package xin.altitude.redis.cluster.config;

import com.google.common.collect.Maps;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.util.CollectionUtils;
import xin.altitude.redis.cluster.constants.CacheNameTimeConstant;

import java.time.Duration;
import java.util.Map;

/**
 * @author explore
 */
@Setter
@Configuration
public class RedisClusterConfig {
    // private Set<String> nodes;
    
    @Autowired
    private RedisProperties redisProperties;
    
    private RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
            //变双冒号为单冒号
            .computePrefixWith(name -> name + ":")
            // 将Value序列化成JSON串
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    
    @Bean
    public RedisConnectionFactory lettuceConnectionFactory() {
        RedisClusterConfiguration configuration = new RedisClusterConfiguration(redisProperties.getCluster().getNodes());
        configuration.setMaxRedirects(3);
        return new LettuceConnectionFactory(configuration);
    }
    
    @Bean
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
        hashMap.put(CacheNameTimeConstant.ONE_DAY, config.entryTtl(Duration.ofDays(1)));
        hashMap.put(CacheNameTimeConstant.SIX_HOURS, config.entryTtl(Duration.ofHours(6)));
        hashMap.put(CacheNameTimeConstant.ONE_HOURS, config.entryTtl(Duration.ofHours(1)));
        hashMap.put(CacheNameTimeConstant.HALF_HOURS, config.entryTtl(Duration.ofMinutes(30)));
        hashMap.put(CacheNameTimeConstant.QUARTER_HOURS, config.entryTtl(Duration.ofMinutes(15)));
        hashMap.put(CacheNameTimeConstant.FIVE_MINS, config.entryTtl(Duration.ofMinutes(5)));
        hashMap.put(CacheNameTimeConstant.ONE_MINS, config.entryTtl(Duration.ofMinutes(1)));
        return hashMap;
    }
    
    /**
     * 自定义key值生成规则
     *
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> String.format("%s:%s(%s)", target.getClass().getName(), method.getName(),
                CollectionUtils.arrayToList(params));
    }
    
    
    // @Bean
    // public LettuceClientConfigurationBuilderCustomizer lettuceClientCustomizer() {
    //     // 配置读写分离
    //     return builder -> builder.readFrom(ReadFrom.REPLICA);
    // }
}
