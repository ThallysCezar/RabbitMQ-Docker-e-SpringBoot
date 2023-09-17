package com.ms.backend.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ms.backend.dtos.PagamentoDTO;
import com.ms.backend.producer.PagamentoRequestProducer;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PagamentoFacade {
	
	@Autowired
	private PagamentoRequestProducer producer;

	public String solicitarPagamento(PagamentoDTO request) {
		try {
			producer.integrar(request);
		} catch (JsonProcessingException e) {
			return "Ocorreu um erro ao solicitar pagamento" + e.getMessage();
		}
		return "Pagamento aguardando confirmacao...";
	}

	public void erroPagamento(String payload) {
		log.error("Resposta com erro {}", payload);
		
	}

	public void sucessoPagamento(String payload) {
		log.info("Resposta com sucesso {}", payload);
		
	}

}
