package br.com.escale.digital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.escale.digital.constants.Codigos;
import br.com.escale.digital.constants.ErrorMessages;
import br.com.escale.digital.dtos.request.EnderecoRequestDTO;
import br.com.escale.digital.dtos.response.MensagemResponseDTO;
import br.com.escale.digital.entity.InformacaoCepEntity;
import br.com.escale.digital.exceptions.ServiceException;
import br.com.escale.digital.repositories.CepRepository;

@Service
public class EnderecoService {

	@Autowired
	//private EnderecoRepository enderecoRepository;
	private CepRepository cepRepository;
	
	private static final String SUCESSO = "Sucesso";
	
	public MensagemResponseDTO inserirEndereco(
			EnderecoRequestDTO endereco) throws ServiceException {

		MensagemResponseDTO mensagemRetorno = new MensagemResponseDTO();

		try {
			InformacaoCepEntity informacaoCepEntity = null;

			validarCep(endereco.cep);
			validarNome(endereco.nome);
						
			informacaoCepEntity = cepRepository.consultarCep(endereco.cep);
			
			if(informacaoCepEntity.getErro() != null && informacaoCepEntity.getErro())
			{
				throw new ServiceException(ErrorMessages.ERRO_PARAMETRO_CEP_NAO_EXISTE, Codigos.ERRO);
			}
			
			//Carregar as informações que foram enviadas na chamada e enviar para o outro repositório para armazenar em banco de dados.
			
			mensagemRetorno.setCodigo(Codigos.SUCESSO.getCodigo());
			mensagemRetorno.setMensagem(SUCESSO);
			mensagemRetorno.setResultado(informacaoCepEntity);

		} catch (Exception ex) {

			mensagemRetorno.setCodigo(Codigos.ERRO.getCodigo());
			mensagemRetorno.setMensagem(ex.getMessage());

		}
		return mensagemRetorno;
	}	
	
	private void validarCep(String cep) throws ServiceException {
		cep = cep.replaceAll("[^a-zZ-Z0-9 ]", ""); 
		if (cep == null || cep.isEmpty())
			throw new ServiceException(ErrorMessages.ERRO_PARAMETRO_NAO_INFORMADO_CEP, Codigos.ERRO);
		if(cep.length() != 8)
			throw new ServiceException(ErrorMessages.ERRO_PARAMETRO_CEP_INCORRETO, Codigos.ERRO);
	}
	
	private void validarNome(String nome) throws ServiceException {
		if (nome == null || nome.isEmpty())
			throw new ServiceException(ErrorMessages.ERRO_PARAMETRO_NAO_INFORMADO_NOME, Codigos.ERRO);
	}
}