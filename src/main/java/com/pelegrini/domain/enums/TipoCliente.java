package com.pelegrini.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int code;
	private String descricao;
	
	private TipoCliente(int cod, String descricao) {
		this.code = cod;
		this.descricao = descricao;
	}

	public int getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoCliente n : TipoCliente.values()) {
			if(cod.equals(n.getCode())) {
				return n;
			}
		}
		
		throw new IllegalArgumentException("Id inválido"+cod);
	}
	
}
