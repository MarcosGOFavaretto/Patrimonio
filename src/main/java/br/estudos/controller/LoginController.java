package br.estudos.controller;

import java.security.InvalidParameterException;

import br.estudos.model.Usuario;
import br.estudos.view.ViewUtils;

public class LoginController {

	Usuario usuario = null;

	public boolean onLogin(String email, String senha) {

		if (ViewUtils.isStringVazia(email))
			throw new InvalidParameterException("O usu�rio informado n�o � v�lido!");

		if (ViewUtils.isStringVazia(senha))
			throw new InvalidParameterException("A senha informada n�o � v�lida!");

		if (email.equals("user") && senha.equals("user")) {
			this.setUsuario(new Usuario());
			return true;
		} else if (email.equals("admin") && senha.equals("admin")) {
			this.setUsuario(new Usuario(true));
			return true;
		} else {
			return false;
		}

	}

	public boolean onAcessoAdminstrador() {

		// TODO: Implementar chamada � tela de administrador

		return false;
	}

	public boolean isAdministrador() {

		if (usuario != null)
			return usuario.isAdministrador();

		return false;

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
