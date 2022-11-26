package br.estudos.view;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import br.estudos.controller.ControllerUtils;
import br.estudos.controller.SolicitarAcessoController;

public class SolicitarAcessoView extends Window implements EventListener<Event> {

	private static final long serialVersionUID = -1044867849762050282L;

	public SolicitarAcessoView() {

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

		Label lblTitulo = new Label("SOLICITAR ACESSO");
		lblTitulo.setStyle("font-size: 20pt");
		layoutVerticalCentralizado.appendChild(lblTitulo);

		layoutVerticalCentralizado.appendChild(new Space());

		Label lblDescricao = new Label();
		lblDescricao.setValue(
				"Para ter acesso ao sistema, por favor, preencha os campos abaixo e clique no botão \"Solicitar acesso\". Após o envio de seus dados, aguarde até que um administrador aceite a sua solicitação. Quando isso ocorrer, você receberá uma notificação no e-mail.");
		layoutVerticalCentralizado.appendChild(lblDescricao);

		layoutVerticalCentralizado.appendChild(new Space());

		Textbox txtNome = new Textbox();
		txtNome.setPlaceholder("Nome");
		layoutVerticalCentralizado.appendChild(txtNome);

		Textbox txtEmail = new Textbox();
		txtEmail.setPlaceholder("Email");
		layoutVerticalCentralizado.appendChild(txtEmail);

		Textbox txtSenha = new Textbox();
		txtSenha.setPlaceholder("Senha");
		txtSenha.setType("password");
		layoutVerticalCentralizado.appendChild(txtSenha);

		Textbox txtConfirmacaoSenha = new Textbox();
		txtConfirmacaoSenha.setPlaceholder("Confirmação da Senha");
		txtConfirmacaoSenha.setType("password");
		layoutVerticalCentralizado.appendChild(txtConfirmacaoSenha);

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
				SolicitarAcessoController.onCriarSolicitacao(event);
			}

		}

	}

}
