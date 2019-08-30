package br.com.escale.digital.constants;

public enum Codigos {
	
	SUCESSO(0),
	ERRO(1);
	
	private final Integer codigo;
	
	Codigos(Integer codigo){
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

}
