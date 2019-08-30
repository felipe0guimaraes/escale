package br.com.escale.digital.repositories.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.escale.digital.entity.InformacaoCepEntity;
import br.com.escale.digital.exceptions.ServiceException;
import br.com.escale.digital.repositories.CepRepository;


@Repository
public class CepRepositoryImpl implements CepRepository {
    
	@Override
	public InformacaoCepEntity consultarCep(String cep) throws ServiceException {
		RestTemplate restTemplate = new RestTemplate();
		String baseUrl = "http://viacep.com.br/ws/"; //Essas informações poderiam ser obtidas dos properties.
		String url = baseUrl + cep + "/json/";
		InformacaoCepEntity informacaoCep = null;

		HttpHeaders headers = new HttpHeaders();
		
		HttpEntity<InformacaoCepEntity> httpEntity = new HttpEntity<>(informacaoCep, headers);
		return restTemplate.exchange(url, HttpMethod.GET, httpEntity, InformacaoCepEntity.class).getBody();
	}
}