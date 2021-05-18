package xin.altitude.mutisourcecache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MutiSourceCacheApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(MutiSourceCacheApplication.class, args);
    }
    
}
