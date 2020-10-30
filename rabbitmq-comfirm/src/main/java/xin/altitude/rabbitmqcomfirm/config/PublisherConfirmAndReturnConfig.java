package xin.altitude.rabbitmqcomfirm.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PublisherConfirmAndReturnConfig implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 类初始化的时候调用此方法
     */
    @PostConstruct
    public void initMethod() {
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 保证消息能够顺利到达exchange
     *
     * @param correlationData
     * @param b
     * @param s
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println("消息已经送达exchange");
        } else {
            System.out.println("消息未送达exchange");
        }
    }
}
