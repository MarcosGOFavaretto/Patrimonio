package br.estudos.controller;

import java.security.InvalidParameterException;

public class LoginController {

	public static boolean onLogin(String usuario, String senha) {

		if (ControllerUtils.isStringVazia(usuario))
			throw new InvalidParameterException("O usu�rio informado para o Login n�o � v�lido!");

		if (ControllerUtils.isStringVazia(senha))
			throw new InvalidParameterException("A senha informada para o Login n�o � v�lida!");

		if (usuario.equals("marcosfavaretto.dev@gmail.com") && senha.equals("123456")) {
			return true;
		} else {
			return false;
		}

	}

}
