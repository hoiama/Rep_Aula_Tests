package br.com.hoiama.model;

import java.util.Comparator;
import java.util.List;

public class Avaliador {

	private double menorLance = Double.POSITIVE_INFINITY;
	private double maiorLance = Double.NEGATIVE_INFINITY;
	private List<Lance> lances;

	public void avaliar(Leilao leilao) {
		
		this.lances = leilao.getListaLances();
		
		this.lances.sort(new Comparator<Lance>(){
			@Override
			public int compare(Lance o1, Lance o2) {
				if(o1.getValor() < o2.getValor()) return 1;
				if(o1.getValor() > o2.getValor()) return -1;
				return 0;
			}
		});
		
		this.lances = this.lances.subList(0, lances.size() > 3 ? 3 : lances.size());

		leilao.getListaLances().forEach(lance -> {
			if (lance.getValor() < menorLance)	menorLance = lance.getValor();
			if (lance.getValor() > maiorLance) 	maiorLance = lance.getValor();
		});
	}

	public List<Lance> getTresMaioresLances() {	return this.lances;}
	public double getMenorLance() {return this.menorLance;}
	public double getMaiorLance() {return this.maiorLance;}
}
