package br.estudos.controller;

import br.estudos.model.Usuario;

public class AdministradorLoginController {

	private String igrejaSelecionada = null;
	private Usuario usuario = null;

	public AdministradorLoginController(Usuario usuario) {

		setUsuario(usuario);

	}

	public boolean onRealizarAcesso(String igrejaSelecionada) {

		this.getUsuario().setIgreja(igrejaSelecionada);
		return true;

	}

	public String getIgrejaSelecionada() {
		return igrejaSelecionada;
	}

	public void setIgrejaSelecionada(String igrejaSelecionada) {
		this.igrejaSelecionada = igrejaSelecionada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
