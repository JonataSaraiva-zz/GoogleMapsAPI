package br.com.own.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.own.bean.Carro;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class SpringBootTemplateProjetoApplicationTests {

	@Test
	public void contextLoads() {
		Carro carro = new Carro();
		carro.setModelo("Fiat Punto 1111");
		
		System.out.println(carro);
		
	}

}
