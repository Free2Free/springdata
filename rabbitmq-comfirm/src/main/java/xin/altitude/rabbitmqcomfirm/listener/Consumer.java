package xin.altitude.rabbitmqcomfirm.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import xin.altitude.rabbitmqcomfirm.entity.ImageEntity;

/**
 * 消息的消费者
 *
 * @author explore
 * @date 2020/10/29 10:23
 */

@Component
public class Consumer {

    /**
     * 默认或者String类型的消息
     *
     * @param message
     */
    @RabbitListener(queues = "topic-queue")
    public void getMessage(Object message) {
        System.out.println("接收到消息1：" + message);
    }

    /**
     * 字符串类型的消息
     *
     * @param message
     */
    @RabbitListener(queues = "topic-queue")
    public void getMessage(String message) {
        System.out.println("接收到消息2：" + message);
    }

    /**
     * 字符串类型的消息
     *
     * @param message
     */
    @RabbitListener(queues = "topic-queue")
    public void getMessage(ImageEntity message) {
        System.out.println("接收到消息3：" + message);
        System.out.println("id = " + message.getId());
        System.out.println("rpath = " + message.getRpath());
    }
}
