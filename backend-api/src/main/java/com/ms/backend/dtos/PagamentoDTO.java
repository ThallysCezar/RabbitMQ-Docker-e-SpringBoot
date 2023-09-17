package com.ms.backend.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDTO {

	private String numeroPedido;
	private BigDecimal valor;
	private String produto;
}
