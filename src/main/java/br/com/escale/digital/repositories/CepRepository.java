package br.com.escale.digital.repositories;

import org.springframework.stereotype.Repository;

import br.com.escale.digital.entity.InformacaoCepEntity;
import br.com.escale.digital.exceptions.ServiceException;

@Repository
public interface CepRepository {
	InformacaoCepEntity consultarCep(String cep) throws ServiceException;
}