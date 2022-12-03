package br.estudos.controller;

import java.security.InvalidParameterException;

public class SolicitarAcessoController {

	public static boolean onCriarSolicitacao(String nome, String email, String senha, String confirmacao) throws Exception {

		if (ViewUtils.isStringVazia(nome))
			throw new InvalidParameterException("O nome informado não é válido!");

		if (ViewUtils.isStringVazia(email))
			throw new InvalidParameterException("O e-mail informado não é válido!");

		if (ViewUtils.isStringVazia(senha))
			throw new InvalidParameterException("A senha informada não é válida!");

		if (ViewUtils.isStringVazia(confirmacao))
			throw new InvalidParameterException("A confirmação da senha informada não é válida!");

		if (!senha.equals(confirmacao))
			throw new Exception("As senhas não coincidem!");

		return true;
	}
}
