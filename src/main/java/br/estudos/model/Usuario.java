package br.estudos.model;

public class Usuario {

	private boolean isAdministrador = false;
	private String igreja = null;
	private String nome = null;

	public Usuario() {}

	public Usuario(String nome, String igreja) {
		this(nome, igreja, false);
	}

	public Usuario(String nome, String igreja, boolean isAdministrador) {
		setNome(nome);
		setIgreja(igreja);
		setIsAdminstrador(isAdministrador);
	}

	public String getIgreja() {
		return igreja;
	}

	public String getIgrejaOnUpperCase() {
		return igreja.toUpperCase();
	}

	public void setIgreja(String igreja) {
		this.igreja = igreja;
	}

	public void setIsAdminstrador(boolean isAdministrador) {
		this.isAdministrador = isAdministrador;
	}

	public boolean isAdministrador() {
		return this.isAdministrador;
	}

	public String getNome() {
		return nome.toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
