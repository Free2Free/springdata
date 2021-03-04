package xin.altitude;

import xin.altitude.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private RedisService service;

//	@Autowired
//	private RedisTemplate

	@Test
	void contextLoads() {
		System.out.println(service.getData(10,"AAAAA",null));
	}

}
