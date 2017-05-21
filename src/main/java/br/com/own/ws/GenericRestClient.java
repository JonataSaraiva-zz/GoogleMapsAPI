package br.com.own.ws;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.own.model.Servico;

@Service
public class GenericRestClient<T> {
	
	private RestTemplate restTemplate;
	
	public GenericRestClient(){
		restTemplate = new RestTemplate();
	}
	
	public <R> Optional<R> consulta(Servico<T, R> servico, T t) {
		
		R responseFromAPI = null;
		
		try {
			responseFromAPI = servico.consomeServico(restTemplate, t);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao consumir API: " + e);
		}
		
		return Optional.ofNullable(responseFromAPI);
	}

}
