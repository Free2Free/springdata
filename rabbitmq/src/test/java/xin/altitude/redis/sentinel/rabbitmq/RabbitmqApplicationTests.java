package xin.altitude.redis.cluster.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 消息生产者
 */
@SpringBootTest
class RabbitmqApplicationTests {


	@Autowired
	RabbitTemplate rabbitTemplate;

	/**
	 * 测试发送文本信息
	 */
	@Test
	void msgText() {
		rabbitTemplate.convertAndSend("topic-exchange","slow.red.dog","注册成功了，需要发送短信通知");
	}


}
