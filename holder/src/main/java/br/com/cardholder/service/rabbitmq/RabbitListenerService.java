package br.com.cardholder.service.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.cardholder.dto.RequestResource;
import br.com.cardholder.service.HolderComponent;

@Service
public class RabbitListenerService {

  public static final String QUEUE_HOLDER = "holder-queue";

  @Autowired
  private HolderComponent holderCompoment;

  @RabbitListener(queues = QUEUE_HOLDER)
  public ResponseEntity<Object> sendToModuleTransaction(RequestResource requestDTO) {
    return holderCompoment.sendRequest(requestDTO);
  }

}
