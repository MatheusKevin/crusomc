package com.pelegrini.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	
	private int code;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
		this.code = cod;
		this.descricao = descricao;
	}

	public int getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (EstadoPagamento n : EstadoPagamento.values()) {
			if(cod.equals(n.getCode())) {
				return n;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
