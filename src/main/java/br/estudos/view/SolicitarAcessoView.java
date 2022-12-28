package br.estudos.view;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import br.estudos.controller.SolicitarAcessoController;
import br.estudos.view.components.ComboboxIgrejas;

public class SolicitarAcessoView extends JanelaPadrao implements EventListener<Event> {

	private static final long serialVersionUID = -1044867849762050282L;

	/** Campos */
	private Textbox txtNome = null;
	private Textbox txtEmail = null;
	private Textbox txtSenha = null;
	private Textbox txtConfirmacaoSenha = null;

	public SolicitarAcessoView(Window win) {

		super(win, true);

		Label lblTitulo = new Label("SOLICITAR ACESSO");
		lblTitulo.setStyle("font-size: 20pt");
		layoutVerticalCentralizado.appendChild(lblTitulo);

		layoutVerticalCentralizado.appendChild(new Space());

		Label lblDescricao = new Label();
		lblDescricao.setValue(
				"Para ter acesso ao sistema, por favor, preencha os campos abaixo e clique no botão \"Solicitar acesso\". Após o envio de seus dados, aguarde até que um administrador aceite a sua solicitação.");
		layoutVerticalCentralizado.appendChild(lblDescricao);

		layoutVerticalCentralizado.appendChild(new Space());

		txtNome = new Textbox();
		txtNome.setPlaceholder("Nome");
		layoutVerticalCentralizado.appendChild(txtNome);

		txtEmail = new Textbox();
		txtEmail.setPlaceholder("Email");
		layoutVerticalCentralizado.appendChild(txtEmail);

		txtSenha = new Textbox();
		txtSenha.setPlaceholder("Senha");
		txtSenha.setType("password");
		layoutVerticalCentralizado.appendChild(txtSenha);

		txtConfirmacaoSenha = new Textbox();
		txtConfirmacaoSenha.setPlaceholder("Confirmação da Senha");
		txtConfirmacaoSenha.setType("password");
		layoutVerticalCentralizado.appendChild(txtConfirmacaoSenha);

		ComboboxIgrejas cmbIgrejas = new ComboboxIgrejas();
		cmbIgrejas.setWidth("33%");
		layoutVerticalCentralizado.appendChild(cmbIgrejas);
		
		layoutVerticalCentralizado.appendChild(new Space());

		Button btnCriarSolicitacao = new Button("Criar Solicitação");
		btnCriarSolicitacao.setId("btnCriarSolicitacao");
		btnCriarSolicitacao.addEventListener(Events.ON_CLICK, this);
		layoutVerticalCentralizado.appendChild(btnCriarSolicitacao);

	}

	@Override
	public void onEvent(Event event) throws Exception {

		String idComponente = event.getTarget().getId();
		String tipoEvento = event.getName();

		if (tipoEvento.equals(Events.ON_CLICK)) {

			if (idComponente.equals("btnCriarSolicitacao")) {
				boolean isSolicitacaoCriada = SolicitarAcessoController.onCriarSolicitacao(
						txtNome.getValue(),
						txtEmail.getValue(),
						txtSenha.getValue(),
						txtConfirmacaoSenha.getValue()
				);

				if (isSolicitacaoCriada) {
					Messagebox.show(
							"Sua solicitação foi enviada aos administradores, aguarde a sua liberação, você será avisado no e-mail.",
							"Solicitação criada!",
							Messagebox.OK,
							Messagebox.INFORMATION,
							Messagebox.OK,
							new EventListener<Event>() {
								@Override
								public void onEvent(Event event) throws Exception {
									Executions.getCurrent().sendRedirect("/index.zul");
								}
							}
					);
					
				}
			}

		}

	}

}
