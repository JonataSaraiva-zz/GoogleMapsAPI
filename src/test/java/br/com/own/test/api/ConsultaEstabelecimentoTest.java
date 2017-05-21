package br.com.own.test.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.own.CaminhoCerto;
import br.com.own.dtos.EstabelecimentoDetails;
import br.com.own.dtos.Resultado;
import br.com.own.model.ConsultaAPIDetailsPlace;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CaminhoCerto.class)
@WebAppConfiguration
public class ConsultaEstabelecimentoTest {
	
	@Autowired
	private ConsultaAPIDetailsPlace consultaApi;
	
	private Resultado resultado;
	
	@Before
	public void setup() {
		resultado = new Resultado();
		resultado.setPlaceId("ChIJrTHFt1RSzpQRewnyHTH8w08");
	}
	
	@Test
	public void retornoDeConsultaPorPlaceIdIgualATresAmigos(){
		EstabelecimentoDetails resultados = consultaApi.porPlaceId(resultado);
		String nomeDoEstabelecimento = resultados.getResult().getName();
		assertEquals("Padaria três amigos", nomeDoEstabelecimento);
	}
	
	@Test( expected=RuntimeException.class )
	public void lancamentoDeExceptionCasoEstabelecimentoNaoEncontrado(){
		resultado = new Resultado();
		resultado.setPlaceId("invalido");
		
		consultaApi.porPlaceId(resultado);
	}
	
	

}
