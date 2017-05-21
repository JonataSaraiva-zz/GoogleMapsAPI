package br.com.own.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.own.bean.UsuarioDados;
import br.com.own.dtos.EstabelecimentoDetails;
import br.com.own.dtos.Response;
import br.com.own.dtos.Resultado;

@Service
public class ConsultaEstabelecimentosProximos {

	private ConsomeDetailsPlace consultaAPIDetailsPlace;
	private ConsomeNearBy consultaAPINearBy;
	
	private Optional<List<EstabelecimentoDetails>> estabelecimentoDetails;

	@Autowired
	ConsultaEstabelecimentosProximos(ConsomeDetailsPlace consultaAPIDetailsPlace, ConsomeNearBy consultaAPINearBy) {
		this.consultaAPIDetailsPlace = consultaAPIDetailsPlace;
		this.consultaAPINearBy = consultaAPINearBy;
	}

	public List<EstabelecimentoDetails> buscaPorInteresse(UsuarioDados usuarioDados) {
		Optional<Response> locais = consultaAPINearBy.porInteresse(usuarioDados);

		locais.ifPresent(local -> {
			estabelecimentoDetails = Optional.ofNullable(buscaDetalhesDosEstabelecimentos(local));
		});
		
		return estabelecimentoDetails.orElseThrow( () -> new RuntimeException("Impossivel obter Estabelecimentos, por favor tente mais tarde!"));
	}

	private List<EstabelecimentoDetails> buscaDetalhesDosEstabelecimentos(Response response) {
		List<Resultado> resultados = response.getResultados();
		return resultados.stream().map( r -> consultaAPIDetailsPlace.porPlaceId(r) ).collect(Collectors.toList());
	}

}
