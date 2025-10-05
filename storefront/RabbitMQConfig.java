package com.seuprojeto.storefront.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.*;

@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("purchase.exchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("purchase.queue", false);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("purchase.routingkey");
    }
}
