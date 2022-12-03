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

import br.estudos.controller.LoginController;
import br.estudos.controller.ViewUtils;

public class LoginView extends Window implements EventListener<Event> {

	private static final long serialVersionUID = -2692789362289500811L;

	private Textbox txtEmail = null;
	private Textbox txtSenha = null;
	private LoginController controller = null;

	public LoginView() {

		controller = new LoginController();

		Vbox layoutVerticalDaJanela = new Vbox();
		layoutVerticalDaJanela.setWidth(ViewUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.setHeight(ViewUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.setAlign(ViewUtils.CENTRO);
		layoutVerticalDaJanela.setPack(ViewUtils.CENTRO);
		this.appendChild(layoutVerticalDaJanela);

		Vbox layoutVerticalCentralizado = new Vbox();
		layoutVerticalCentralizado.setWidth(ViewUtils.CINQUENTA_POR_CENTO);
		layoutVerticalCentralizado.setHeight(ViewUtils.CEM_POR_CENTO);
		layoutVerticalCentralizado.setAlign(ViewUtils.CENTRO);
		layoutVerticalCentralizado.setPack(ViewUtils.CENTRO);
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
				boolean isUsuarioReconhecido = controller.onLogin(txtEmail.getValue(), txtSenha.getValue());
				boolean isAdministrador = controller.isAdministrador();

				if (!isUsuarioReconhecido)
					Messagebox.show("Usuário não reconhecido!");

				if (isAdministrador) {
					controller.onAcessoAdminstrador();
				}
				

			}

		}

	};
}
