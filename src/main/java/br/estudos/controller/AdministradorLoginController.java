package br.estudos.controller;

public class AdministradorLoginController {

	private String igrejaSelecionada = null;

	public boolean onRealizarAcesso(String igrejaSelecionada) {

		this.igrejaSelecionada = igrejaSelecionada;
		return true;

	}
}
