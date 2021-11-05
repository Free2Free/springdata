package xin.altitude.redis.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisSentinelApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RedisSentinelApplication.class, args);
    }
}
