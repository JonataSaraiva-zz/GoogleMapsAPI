package br.com.own.model;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



/**
 * @param <IN> - OBJETO COM INFORMACOES PARA CONSULTA
 * @param <OUT> OBJETO QUE REPRESENTA O RETORNO DA CONSULTA
 */
@Service
public interface Servico<IN, OUT> {

	public String getUrlDeRequest(IN in);
	public OUT consomeServico(RestTemplate restTemplate, IN in);

}
