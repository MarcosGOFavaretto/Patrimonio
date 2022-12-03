package br.estudos.view;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import br.estudos.controller.LoginController;

public class LoginView extends JanelaPadraoCentralizada implements EventListener<Event> {

	private static final long serialVersionUID = -2692789362289500811L;

	private Textbox txtEmail = null;
	private Textbox txtSenha = null;

	private LoginController controller = null;

	public LoginView(Window win) {

		super(win);
		controller = new LoginController();

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
					ViewUtils.removerItensDaJanela(getWindow());
					for (Component componente : new AdministradorLoginView(getWindow()).getChildren())
						getWindow().appendChild(componente);
				}

			}

		}

	};
}
