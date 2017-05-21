package br.com.own.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.own.dtos.EstabelecimentoDetails;
import br.com.own.dtos.Resultado;
import br.com.own.exceptions.InvalidRequest;
import br.com.own.ws.GenericRestClient;

@Service
public class ConsomeDetailsPlace {

	@Autowired
	@Qualifier("APIDetailsPlace")
	private Servico<Resultado , EstabelecimentoDetails> servico;

	private GenericRestClient<Resultado> genericRestClient;

	@Autowired
	public ConsomeDetailsPlace( GenericRestClient<Resultado> client ) {
		this.genericRestClient = client;
	}

	public EstabelecimentoDetails porPlaceId(Resultado resultado) {
		Optional<EstabelecimentoDetails> resposta = genericRestClient.consulta(servico, resultado);

		validResponseReturned(resposta);

		return resposta.orElseThrow(() -> new RuntimeException("Request Invalida"));
	}

	private void validResponseReturned(Optional<EstabelecimentoDetails> resposta) {
		resposta.ifPresent(r -> {
			if (r.getStatus().equals("INVALID_REQUEST")) {
				throw new InvalidRequest("Solicitação invalida, verifique as informações e tente novamente");
			}
		});
	}

}
