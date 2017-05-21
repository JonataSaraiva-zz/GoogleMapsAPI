package br.com.own.model;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.own.bean.UsuarioDados;
import br.com.own.dtos.Response;

@Service
public class APINearBy implements Servico<UsuarioDados, Response> {
	
	private final String URL = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location=%s,%s&radius=5000&name=%s&key=AIzaSyAk7R1lDzaPbTLG8AFPacjV4ZyTwY6q5rY";

	@Override
	public String getUrlDeRequest(UsuarioDados usuarioDados) {
		return String.format(URL, usuarioDados.getLatitude(), usuarioDados.getLongetude(), usuarioDados.getInteresse());
	}

	@Override
	public Response consomeServico(RestTemplate restTemplate, UsuarioDados usuarioDados) {
		return restTemplate.exchange(getUrlDeRequest(usuarioDados), HttpMethod.GET, null, new ParameterizedTypeReference<Response>() {} ).getBody();
	}

}
