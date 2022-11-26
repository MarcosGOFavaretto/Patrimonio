package br.estudos.view;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.MessageboxDlg;

import br.estudos.controller.ControllerUtils;
import br.estudos.controller.LoginController;

public class LoginView extends Window implements EventListener<Event> {

	private static final long serialVersionUID = -2692789362289500811L;

	private Textbox txtEmail = null;
	private Textbox txtSenha = null;

	public LoginView() {
		Vbox layoutVerticalDaJanela = new Vbox();
		layoutVerticalDaJanela.setWidth(ControllerUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.setHeight(ControllerUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.setAlign(ControllerUtils.CENTRO);
		layoutVerticalDaJanela.setPack(ControllerUtils.CENTRO);
		this.appendChild(layoutVerticalDaJanela);

		Vbox layoutVerticalCentralizado = new Vbox();
		layoutVerticalCentralizado.setWidth(ControllerUtils.CINQUENTA_POR_CENTO);
		layoutVerticalCentralizado.setHeight(ControllerUtils.CEM_POR_CENTO);
		layoutVerticalCentralizado.setAlign(ControllerUtils.CENTRO);
		layoutVerticalCentralizado.setPack(ControllerUtils.CENTRO);
		layoutVerticalDaJanela.appendChild(layoutVerticalCentralizado);

		Label lblTitulo = new Label("REALIZAR ACESSO");
		lblTitulo.setStyle("font-size: 20pt");
		layoutVerticalCentralizado.appendChild(lblTitulo);

		layoutVerticalCentralizado.appendChild(new Space());

		txtEmail = new Textbox();
		txtEmail.setPlaceholder("Email");
		layoutVerticalCentralizado.appendChild(txtEmail);

		txtSenha = new Textbox();
		txtSenha.setPlaceholder("Senha");
		txtSenha.setType("password");
		layoutVerticalCentralizado.appendChild(txtSenha);

		layoutVerticalCentralizado.appendChild(new Space());

		Button btnRealizarLogin = new Button("Realizar Login");
		btnRealizarLogin.setId("btnRealizarLogin");
		btnRealizarLogin.addEventListener(Events.ON_CLICK, this);
		layoutVerticalCentralizado.appendChild(btnRealizarLogin);
	}

	@Override
	public void onEvent(Event event) throws Exception {

		String idComponente = event.getTarget().getId();
		String tipoEvento = event.getName();

		if (tipoEvento.equals(Events.ON_CLICK)) {

			if (idComponente.equals("btnRealizarLogin")) {
				boolean isUsuarioReconhecido = LoginController.onLogin(txtEmail.getValue(), txtSenha.getValue());

				if (isUsuarioReconhecido) {
					Messagebox.show("Usuário reconhecido!");
				} else {
					Messagebox.show("Usuário não reconhecido!");
				}

			}

		}

	};
}
