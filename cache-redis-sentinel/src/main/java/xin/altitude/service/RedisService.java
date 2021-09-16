package xin.altitude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import xin.altitude.constants.CacheNameConstant;
import xin.altitude.constants.CacheNameTimeConstant;
import xin.altitude.domain.User;

import java.time.Duration;
import java.util.Date;

/**
 * 操作全局配置文件中的数据
 *
 * @author explore
 */
@Service
// 从默认数据源中读取CacheManager
@CacheConfig(cacheNames = CacheNameConstant.DEFAULT, keyGenerator = "keyGenerator")
public class RedisService {
    @Autowired
    private RedisConnectionFactory lettuceConnectionFactory;
    
    @Cacheable()
    public String getData(Integer a, Integer b) {
        System.out.println("第一次调用方法，第二次之后就直接从缓存取数据");
        return String.format("%d,%d", a, b);
    }
    
    /**
     * 无参数
     *
     * @return
     */
    @Cacheable()
    public User getUser() {
        System.out.println("方法执行进入方法体");
        return new User(1, "AAA").setCreateTime(new Date());
    }
    
    /**
     * 普通参数
     *
     * @return
     */
    @Cacheable(cacheNames = CacheNameTimeConstant.HALF_HOURS)
    public User getUser2(Integer userId, String userName) {
        System.out.println("方法执行进入方法体");
        return new User(userId, userName);
    }
    
    /**
     * 对象参数
     *
     * @param user
     * @return
     */
    @Cacheable(cacheNames = CacheNameTimeConstant.FIVE_MINS)
    public User getUser3(User user) {
        System.out.println("方法执行进入方法体");
        return user;
    }
    
    /**
     * 使用template
     */
    public String getString() {
        StringRedisTemplate template = new StringRedisTemplate(lettuceConnectionFactory);
        String value = template.opsForValue().get("111");
        if (value == null) {
            System.out.println("方法执行进入方法体");
            template.opsForValue().set("111", "111", Duration.ofSeconds(60));
        }
        return template.opsForValue().get("111");
    }
}
