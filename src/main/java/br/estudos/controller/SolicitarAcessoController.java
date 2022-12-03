package br.estudos.controller;

import java.security.InvalidParameterException;

public class SolicitarAcessoController {

	public static boolean onCriarSolicitacao(String nome, String email, String senha, String confirmacao) throws Exception {

		if (ViewUtils.isStringVazia(nome))
			throw new InvalidParameterException("O nome informado n�o � v�lido!");

		if (ViewUtils.isStringVazia(email))
			throw new InvalidParameterException("O e-mail informado n�o � v�lido!");

		if (ViewUtils.isStringVazia(senha))
			throw new InvalidParameterException("A senha informada n�o � v�lida!");

		if (ViewUtils.isStringVazia(confirmacao))
			throw new InvalidParameterException("A confirma��o da senha informada n�o � v�lida!");

		if (!senha.equals(confirmacao))
			throw new Exception("As senhas n�o coincidem!");

		return true;
	}
}
