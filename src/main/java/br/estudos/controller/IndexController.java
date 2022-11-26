package br.estudos.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

import br.estudos.view.LoginView;
import br.estudos.view.SolicitarAcessoView;

/*
 * TODO: Estudar o Composer da ZK.
 */
public class IndexController extends SelectorComposer<Window> {

	private static final long serialVersionUID = 8701183894738754988L;

	@Wire
	private Window win;

	Button btnCriarSolicitacao = null;

	@Listen("onClick = #btnPossuoAcesso")
	public void onPossuirAcesso(Event event) {
		ControllerUtils.removerItensDaJanela(win);
		for (Component componente : new LoginView().getChildren())
			win.appendChild(componente);
	}

	@Listen("onClick = #btnSolicitarAcesso")
	public void onSolicitarAcesso(Event event) {
		ControllerUtils.removerItensDaJanela(win);
		for (Component componente : new SolicitarAcessoView().getChildren())
			win.appendChild(componente);
	}

}
