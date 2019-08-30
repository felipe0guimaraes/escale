package br.com.escale.digital.dtos.response;

public class MensagemResponseDTO {

	private Integer codigo;
	
	private String mensagem;
	
	private Object resultado;
	
	public MensagemResponseDTO () {}
	
	public MensagemResponseDTO (Integer codErro, String mensagem, Object resultado) {
		
		this.codigo = codErro;
		this.mensagem = mensagem;
		this.resultado = resultado;
		
	}

	public Object getResultado() {
		return resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
