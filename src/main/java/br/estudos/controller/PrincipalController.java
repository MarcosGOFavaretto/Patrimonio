package br.estudos.controller;

import br.estudos.model.Usuario;

public class PrincipalController {

	private Usuario usuario = null;

	public PrincipalController(Usuario usuario) {
		this.usuario = usuario;
	}

	public void onAddRecord() {
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
