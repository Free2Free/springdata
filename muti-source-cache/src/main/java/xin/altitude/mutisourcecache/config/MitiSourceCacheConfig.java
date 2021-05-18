package xin.altitude.mutisourcecache.config;

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
        RedisCacheManager manager = getRedisCacheManager(factory, redisCacheConfiguration);
        return manager;
    }
    
    private RedisCacheManager getRedisCacheManager(LettuceConnectionFactory factory, RedisCacheConfiguration redisCacheConfiguration) {
        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(factory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                // 初始化不同CACHENAME的过期过期时间
                .withInitialCacheConfigurations(CacheNameTimeConstant.initialCacheConfigurations(redisCacheConfiguration))
                .build();
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
    public CacheManager redisDb02CacheManager(final LettuceConnectionFactory factory) {
        LettuceConnectionFactory lettuceConnectionFactory = createLettuceConnectionFactory(factory);
        
        // 全局配置默认过期时间
        RedisCacheConfiguration redisCacheConfiguration = config.entryTtl(Duration.ofHours(1));
        RedisCacheManager manager = getRedisCacheManager(lettuceConnectionFactory, redisCacheConfiguration);
        return manager;
    }
    
    /**
     * 获取新的Redis连接工厂
     *
     * @param factory 调用方法传递的参数，不是容器中获取的
     * @return LettuceConnectionFactory
     */
    private LettuceConnectionFactory createLettuceConnectionFactory(final LettuceConnectionFactory factory) {
        // 获取容器中已存在的Redis连接配置
        RedisStandaloneConfiguration configuration = factory.getStandaloneConfiguration();
        // 修改连接数据库
        configuration.setDatabase(9);
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(configuration);
        // 此语句非常重要
        lettuceConnectionFactory.afterPropertiesSet();
        return lettuceConnectionFactory;
    }
}
