package xin.altitude.listen;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class ConsumerClient {

    @RabbitListener(queues = "topic-queue")
    public void getMessage(Object message) {
        System.out.println("接收到消息：" + message);
    }

//    @RabbitListener(queues = "topic-queue")
//    public void getMessage(String msg, Channel channel, Message message) {
//        System.out.println("接收到消息：" + message);
//        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
