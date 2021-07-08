package com.aquicksoft.dto;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig2 {

	public static final String QUEUE = "QC_NEW_IMAGE_FOUND";
	public static final String EXCHANGE = "QC_NEW_IMAGE_FOUND_exchange";
	public static final String ROUTING_KEY = "QC_NEW_IMAGE_FOUND_routingKey";

	@Bean
	public Queue queue2() {
		return new Queue(QUEUE);
	}

	@Bean
	public TopicExchange exchange2() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	public Binding binding2(Queue queue2, TopicExchange exchange2) {
		return BindingBuilder.bind(queue2).to(exchange2).with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter converter2() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template2(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter2());
		return rabbitTemplate;
	}
}
