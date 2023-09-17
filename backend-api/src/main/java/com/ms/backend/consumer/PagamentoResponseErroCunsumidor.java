package com.ms.backend.consumer;

import java.time.LocalDateTime;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.backend.facade.PagamentoFacade;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PagamentoResponseErroCunsumidor {

	@Autowired
	private PagamentoFacade pagamentoFacade;
	
	@RabbitListener(queues = {"pagamento-response-erro-queue"})
	public void receive(@Payload Message<?> message) {
		log.info(String.format("Message %s %s", message, LocalDateTime.now()));
		String payload = String.valueOf(message.getPayload());
		
		pagamentoFacade.erroPagamento (payload);
	}
}
