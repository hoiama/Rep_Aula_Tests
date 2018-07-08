package br.com.hoiama.model;

import java.util.ArrayList;

public class Leilao {

	private ArrayList<Lance> listaLances;
	private String descricao;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.listaLances = new ArrayList<Lance>();
	}

	public void setLance(Lance lance) {
		this.listaLances.add(lance);
	}

	public ArrayList<Lance> getListaLances() {
		return listaLances;
	}

	public String getDescricao() {
		return descricao;
	}

}
