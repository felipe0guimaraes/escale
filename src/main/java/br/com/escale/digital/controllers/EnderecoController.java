package br.com.escale.digital.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.escale.digital.dtos.request.EnderecoRequestDTO;
import br.com.escale.digital.dtos.response.MensagemResponseDTO;
import br.com.escale.digital.exceptions.ServiceException;
import br.com.escale.digital.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/endereco", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = { "Endereco" })
public class EnderecoController {
	
	private EnderecoService enderecoService;
	
	private static final String SUCESSO = "Sucesso";
	
	@Autowired
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	@PostMapping("/inserir")
	@ApiOperation(value="Insere Endereco")
	public ResponseEntity<MensagemResponseDTO> inserirEndereco (@ApiParam(value="CEP,Nome",required = true)
														@RequestBody  @Valid EnderecoRequestDTO endereco) throws ServiceException{
		
		MensagemResponseDTO mensagemRetorno = enderecoService.inserirEndereco(endereco);
		
		if (mensagemRetorno.getCodigo() == 0)
			mensagemRetorno.setMensagem(SUCESSO);
		
		return ResponseEntity.ok().body(mensagemRetorno);
	}
}
