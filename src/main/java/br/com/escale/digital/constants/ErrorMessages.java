package br.com.escale.digital.constants;

public enum ErrorMessages {
		
	ERRO_PARAMETROS_INVALIDOS("Parâmetros inválidos."),
	ERRO_PARAMETRO_NAO_INFORMADO_NOME("Nome não informado. Parâmetro Obrigatório."),
	ERRO_PARAMETRO_NAO_INFORMADO_CEP("CEP não informado. Parâmetro Obrigatório."),
	ERRO_PARAMETRO_CEP_INCORRETO("O CEP informado de maneira incorreta. Utilize o formato: 01234-567."),
	ERRO_PARAMETRO_CEP_NAO_EXISTE("Não foi possível encontrar endereço para o CEP fornecido.");
	
	private final String erro;

	ErrorMessages(String errorCode) {
		erro = errorCode;
	}
	
	public String getErro() {
		return erro;
	}
}
