package xin.altitude.redis.cluster.rabbitmq.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息的消费者
 *
 * @author explore
 * @date 2020/10/29 10:23
 */

@Component
public class Consumer {

//    /**
//     * 默认或者String类型的消息
//     *
//     * @param message
//     */
//    @RabbitListener(queues = "topic-queue")
//    public void getMessage1(Object message) {
//        System.out.println("接收到消息1：" + message);
//    }

    /**
     * 字符串类型的消息
     *
     * @param message
     */
    @RabbitListener(queues = "topic-queue")
    public void getMessage2(String message) {
        System.out.println("接收到消息2：" + message);
    }

//    /**
//     * 字符串类型的消息
//     *
//     * @param message
//     */
//    @RabbitListener(queues = "topic-queue")
//    public void getMessage3(ImageEntity message) {
//        System.out.println("message.getId() = " + message.getId());
//        System.out.println("message.getRpath() = " + message.getRpath());
//        System.out.println("接收到消息3：" + message);
//    }
}
