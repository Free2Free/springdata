package xin.altitude.rabbitmq.controller;

import xin.altitude.rabbitmq.entity.ImageEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author explore
 * @date 2020/10/29 10:38
 */
@RestController
public class IndexController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 测试发送文本信息
     */
    @GetMapping("/msgText")
    public void msgText() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("topic-exchange","slow.red.dog","注册成功了，需要发送短信通知"+i);
        }
    }

//    @GetMapping("/msgImage")
//    public void msgImage() {
//        ImageEntity image = new ImageEntity(1,"/aa/bb/cc");
//
//        rabbitTemplate.convertAndSend("topic-exchange","slow.red.dog",image);
//    }

}
