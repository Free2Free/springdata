package xin.altitude.redis.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisClusterApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RedisClusterApplication.class, args);
    }
}
