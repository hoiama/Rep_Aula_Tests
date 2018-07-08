package br.com.hoiama.model;

public class Usuario {

	private int idUsuario;
	private String nome;

	public Usuario(String nome) {
		this.nome = nome;
	}

	public Usuario(int id, String nome) {
		this.idUsuario = id;
		this.nome = nome;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
