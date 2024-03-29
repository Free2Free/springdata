package xin.altitude.redis.cluster.caffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheCaffeineApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CacheCaffeineApplication.class, args);
    }
    
}
