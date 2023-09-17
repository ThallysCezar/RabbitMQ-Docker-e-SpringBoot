package com.ms.backend.worker.consumer;

import java.util.Random;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.backend.worker.producer.PagamentoErroProdutor;
import com.ms.backend.worker.producer.PagamentoSucessoProdutor;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class PagamentoRequestConsumer {

	@Autowired
	private PagamentoErroProdutor erroProdutor;
	
	@Autowired
	private PagamentoSucessoProdutor sucessoProdutor;
	
	@RabbitListener(queues = {"pagamento-request-queue"})
	public void receberMensagem(@Payload Message<?> message) {
		log.info(message);
		if(new Random().nextBoolean()) {
			sucessoProdutor.gerarResposta("Mensagem de sucesso Pagamento" + message);
		} else {
			erroProdutor.gerarResposta("ERRO no Pagamento" + message);
		}
	}
}
