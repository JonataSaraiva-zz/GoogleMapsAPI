package br.com.own.model;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.own.dtos.EstabelecimentoDetails;
import br.com.own.dtos.Resultado;

@Service
public class APIDetailsPlace implements Servico<Resultado, EstabelecimentoDetails> {

	private final String URL = "https://maps.googleapis.com/maps/api/place/details/json?placeid=%s&key=AIzaSyAk7R1lDzaPbTLG8AFPacjV4ZyTwY6q5rY";

	@Override
	public String getUrlDeRequest(Resultado resultado) {
		return String.format( URL , resultado.getPlaceId() );
	}

	@Override
	public EstabelecimentoDetails consomeServico(RestTemplate restTemplate, Resultado resultado) {
		return restTemplate.exchange(getUrlDeRequest(resultado), HttpMethod.GET, null, new ParameterizedTypeReference<EstabelecimentoDetails>() {} ).getBody();
	}

}
