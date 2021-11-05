package xin.altitude.redis.sentinel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xin.altitude.redis.sentinel.service.RedisService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTests {
    
    @Autowired
    private RedisService service;

//	@Autowired
//	private RedisTemplate
    
    public static List<String> diffSet(List<String> listA, List<String> listB) {
        List<String> lists = new ArrayList<>(listA.size());
        // 复制一个新集合
        lists.addAll(listA);
        // 并集
        lists.addAll(listB);
        // 差集
        lists.removeAll(listB);
        return lists;
    }
    
    @Test
    void contextLoads() {
//		System.out.println(service.getData(10,"AAAAA",null));
    }
    
    @Test
    public void test36() {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ISO_DATE);
        format = now.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("format = " + format);
    }
}
