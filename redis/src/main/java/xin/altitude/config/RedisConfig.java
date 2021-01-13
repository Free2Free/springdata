package xin.altitude.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Key值生成规则
 */
//@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (taget, method, param) -> {
            String tagetName = taget.getClass().getName();
            String methodName = method.getName();
            String key = tagetName + "_" + methodName + "_" + param.toString();
            System.out.println("key = " + key);
            return key;

        };
    }
}

