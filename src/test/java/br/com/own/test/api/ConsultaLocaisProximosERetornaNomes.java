package br.com.own.test.api;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.own.CaminhoCerto;
import br.com.own.bean.UsuarioDados;
import br.com.own.dtos.EstabelecimentoDetails;
import br.com.own.model.ConsultaEstabelecimentosProximos;
import br.com.own.model.Interesse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CaminhoCerto.class)
@WebAppConfiguration
public class ConsultaLocaisProximosERetornaNomes {
	
	@Autowired
	private ConsultaEstabelecimentosProximos consultaEstabelecimentosProximos;
	
	private UsuarioDados usuarioDados;
	
	@Before
	public void setup() {
		usuarioDados = new UsuarioDados();
		usuarioDados.setLatitude("-23.6782926");
		usuarioDados.setLongetude("-46.7818652");
		usuarioDados.setInteresse(Interesse.ACADEMIA);
	}
	

	@Test
	public void seLocaisProximosRetornadosPossuemEstabelecimentosEsperados(){
		List<EstabelecimentoDetails> estabelecimentos = consultaEstabelecimentosProximos.buscaPorInteresse(usuarioDados);
		
		estabelecimentos.forEach(e -> System.out.println(e.getResult().getName() + " | " + e.getResult().getRating() ));
	}
	
}
