package br.estudos.controller;

import br.estudos.model.Usuario;

public class PrincipalController {

	private Usuario usuario = null;

	public PrincipalController(Usuario usuario) {
		this.setUsuario(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
