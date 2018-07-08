package br.com.hoiama.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AvaliadorTest {

	@Test
	public void main() {

		Usuario joao = new Usuario("joao");
		Usuario maria = new Usuario("maria");
		Usuario jose = new Usuario("jose");

		Lance lance1 = new Lance(joao, 900);
		Lance lance2 = new Lance(jose, 700);
		Lance lance3 = new Lance(maria, 500);

		Leilao leilaoBike = new Leilao("o maior leilao de bikes");
		leilaoBike.setLance(lance1);
		leilaoBike.setLance(lance2);
		leilaoBike.setLance(lance3);

		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilaoBike);

		double menorEsperado = 500;
		double maiorEsperado = 900;

		assertEquals(menorEsperado, avaliador.getMenorLance(), 0.0001);
		assertEquals(maiorEsperado, avaliador.getMaiorLance(), 0.0001);
	}

	@Test
	public void tresMaioresLances() {

		Usuario joao = new Usuario("joao");
		Usuario maria = new Usuario("maria");
		Usuario jose = new Usuario("jose");
		Usuario barbara = new Usuario("barbara");

		Lance lance1 = new Lance(joao, 900);
		Lance lance2 = new Lance(jose, 700);
		Lance lance3 = new Lance(maria, 500);
		Lance lance4 = new Lance(barbara, 500);

		Leilao leilaoBike = new Leilao("o maior leilao de bikes");
		leilaoBike.setLance(lance1);
		leilaoBike.setLance(lance2);
		leilaoBike.setLance(lance3);
		leilaoBike.setLance(lance4);

		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilaoBike);
		
		List<Lance> lances =  avaliador.getTresMaioresLances();
		assertEquals(3, lances.size());
		assertEquals(900, lances.get(0).getValor(), 0.001);
		assertEquals(700, lances.get(1).getValor(), 0.001);
		assertEquals(500, lances.get(2).getValor(), 0.001);
		assertEquals(900, avaliador.getMaiorLance(), 0.001);
		assertEquals(500, avaliador.getMenorLance(), 0.001);
		assertEquals(avaliador.getMaiorLance(), lances.get(0).getValor(), 0.01);
	}

	@Test
	public void unicoLance() {

		Usuario joao = new Usuario("joao");
		Lance lance1 = new Lance(joao, 900);
		Leilao leilaoBike = new Leilao("o maior leilao de bikes");
		leilaoBike.setLance(lance1);

		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilaoBike);

		assertEquals(1, avaliador.getTresMaioresLances().size());
	}

	@Test
	public void doisLances() {

		Usuario joao = new Usuario("joao");
		Usuario maria = new Usuario("maria");

		Lance lance1 = new Lance(joao, 900);
		Lance lance2 = new Lance(maria, 700);

		Leilao leilaoBike = new Leilao("o maior leilao de bikes");
		leilaoBike.setLance(lance1);
		leilaoBike.setLance(lance2);

		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilaoBike);

		assertEquals(2, avaliador.getTresMaioresLances().size());
	}
}
