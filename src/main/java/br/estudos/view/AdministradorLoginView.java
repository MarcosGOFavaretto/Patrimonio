package br.estudos.view;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Space;
import org.zkoss.zul.Window;

import br.estudos.controller.AdministradorLoginController;

public class AdministradorLoginView extends JanelaPadraoCentralizada implements EventListener<Event> {

	private static final long serialVersionUID = -376686657139317562L;

	private static final int PRIMEIRA_OPCAO_DE_IGREJA = 0;

	private AdministradorLoginController controller = null;
	private Combobox cmbIgrejas = null;

	public AdministradorLoginView(Window win) {
		super(win);
		controller = new AdministradorLoginController();

		Label lblTitulo = new Label("REALIZAR ACESSO COMO ADMINISTRADOR");
		lblTitulo.setStyle("font-size: 20pt");
		layoutVerticalCentralizado.appendChild(lblTitulo);

		layoutVerticalCentralizado.appendChild(new Space());

		Label lblDescricao = new Label();
		lblDescricao.setValue("Olá Administrador! Por favor, selecione a Igreja que deseja acessar.");
		layoutVerticalCentralizado.appendChild(lblDescricao);

		layoutVerticalCentralizado.appendChild(new Space());

		cmbIgrejas = new Combobox();
		cmbIgrejas.appendItem("Igreja 1");
		cmbIgrejas.appendItem("Igreja 2");
		cmbIgrejas.appendItem("Igreja 3");
		cmbIgrejas.appendItem("Paróquia");
		cmbIgrejas.setSelectedIndex(PRIMEIRA_OPCAO_DE_IGREJA);
		layoutVerticalCentralizado.appendChild(cmbIgrejas);

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

				String igrejaSelecionada = cmbIgrejas.getValue();
				if (controller.onRealizarAcesso(igrejaSelecionada))
					// TODO: Chamar a tela principal.
					Messagebox.show("Logando como \"" + igrejaSelecionada + "\"");

			}

		}

	}
}
