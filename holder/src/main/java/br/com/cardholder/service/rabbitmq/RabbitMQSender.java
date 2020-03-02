package br.com.cardholder.service.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.cardholder.dto.RequestResource;

@Component
public class RabbitMQSender {

    @Value("${queue.holder}")
    private String queueHolder;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTransaction(RequestResource requestDTO) {
        rabbitTemplate.convertAndSend(queueHolder, requestDTO);
    }

}
