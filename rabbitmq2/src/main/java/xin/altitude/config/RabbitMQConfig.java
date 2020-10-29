package xin.altitude.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /**
     * 创建exchange-topic
     * @return
     */
    @Bean
    public TopicExchange getTopicExchange(){
        return new TopicExchange("topic-exchange",true,false);
    }
    /**
     * 创建队列
     */
    @Bean
    public Queue getQueue(){
        return new Queue("topic-queue",true,false,false,null);
    }

    /**
     * 将exchange和queue绑定在一起
     * @param exchange 自动从容器中给参数取值并且赋值
     * @param queue 自动从容器中给参数取值并且赋值
     * @return
     */
    @Bean
    public Binding getBinding(TopicExchange exchange,Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("*.red.*");
    }
}
