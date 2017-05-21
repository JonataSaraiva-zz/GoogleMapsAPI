package br.com.own.test.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.own.CaminhoCerto;
import br.com.own.bean.UsuarioDados;
import br.com.own.dtos.Response;
import br.com.own.model.ConsultaAPINearBy;
import br.com.own.model.Interesse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CaminhoCerto.class)
@WebAppConfiguration
public class ConsultaLocaisPorProximidadeTest {
	
	@Autowired
	private ConsultaAPINearBy consultaAPINearBy;

	private UsuarioDados usuarioDados;
	
	@Before
	public void setup() {
		usuarioDados = new UsuarioDados();
		usuarioDados.setLatitude("-23.6782926");
		usuarioDados.setLongetude("-46.7818652");
		usuarioDados.setInteresse(Interesse.PADARIA);
	}
	
	@Test
	public void seSaoRetornadosLocaisProximosALocalizacaoFornecida(){
		Optional<Response> resposta = consultaAPINearBy.porInteresse(usuarioDados);
		
		if( resposta.isPresent() )
			assertTrue(resposta.get().getResultados().size() > 0);
		
		else
			assertFalse(true);
		
	}

}
