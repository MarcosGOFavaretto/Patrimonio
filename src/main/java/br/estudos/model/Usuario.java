package br.estudos.model;

public class Usuario {

	private boolean isAdministrador = false;

	public Usuario() {}

	public Usuario(boolean isAdministrador) {
		setIsAdminstrador(isAdministrador);
	}

	public void setIsAdminstrador(boolean isAdministrador) {
		this.isAdministrador = isAdministrador;
	}

	public boolean isAdministrador() {
		return this.isAdministrador;
	}

}
