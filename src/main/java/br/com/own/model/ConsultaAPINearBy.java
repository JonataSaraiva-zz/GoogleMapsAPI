package br.com.own.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.own.bean.UsuarioDados;
import br.com.own.dtos.Response;
import br.com.own.ws.GenericRestClient;

@Service
public class ConsultaAPINearBy  {
	
	@Autowired
	@Qualifier("APINearBy")
	private Servico<UsuarioDados, Response> servico;

	private GenericRestClient<UsuarioDados> genericRest;

	@Autowired
	public ConsultaAPINearBy(GenericRestClient<UsuarioDados> genericRestClient) {
		this.genericRest = genericRestClient;
	}
	
	public Optional<Response> porInteresse(UsuarioDados usuarioDados){
		return genericRest.consulta(servico, usuarioDados);
	}

}
