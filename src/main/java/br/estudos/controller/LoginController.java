package br.estudos.controller;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

/*
 * TODO: Estudar o Composer da ZK.
 */
public class LoginController extends SelectorComposer<Window> {

	private static final long serialVersionUID = 8701183894738754988L;

	@Listen("onClick = #btnLogin")
	public void onLogin(Event event) {
		System.out.println("Um evento de login foi iniciado!");
	}
}
