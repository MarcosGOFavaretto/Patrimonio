package br.estudos.view;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

import br.estudos.controller.PrincipalController;
import br.estudos.model.Usuario;

public class PrincipalView extends JanelaPadrao implements EventListener<Event> {

	private static final long serialVersionUID = 5795042314679821267L;

	private PrincipalController controller = null;

	/** Componentes */
	Toolbarbutton btnConfigurar = null;
	Toolbarbutton btnAdicionar = null;
	Toolbarbutton btnSair = null;

	public PrincipalView(Window win, Usuario usuario) {

		super(win, false);
		win.setBorder("none");
		win.setTitle(usuario.getIgreja());

		controller = new PrincipalController(usuario);


		Tabbox layoutAbas = new Tabbox();
		layoutAbas.setWidth(ViewUtils.CEM_POR_CENTO);
		layoutAbas.setHeight(ViewUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.appendChild(layoutAbas);

		Tabs titulosAbas = new Tabs();
		layoutAbas.appendChild(titulosAbas);

		Tab tituloAba = new Tab("Igreja");
		titulosAbas.appendChild(tituloAba);

		tituloAba = new Tab("Objetos Litúrgicos");
		titulosAbas.appendChild(tituloAba);

		tituloAba = new Tab("Cozinha (Itens Grandes)");
		titulosAbas.appendChild(tituloAba);

		tituloAba = new Tab("Cozinha (Itens Pequenos)");
		titulosAbas.appendChild(tituloAba);

		tituloAba = new Tab("Salão/Salas");
		titulosAbas.appendChild(tituloAba);

		Toolbar barraFerramentas = new Toolbar();
		layoutAbas.appendChild(barraFerramentas);

		btnConfigurar = new Toolbarbutton();
		btnConfigurar.setTooltiptext("Configurar");
		btnConfigurar.setIconSclass("z-icon-gear");
		btnConfigurar.addEventListener(Events.ON_CLICK, this);
		barraFerramentas.appendChild(btnConfigurar);

		btnAdicionar = new Toolbarbutton();
		btnAdicionar.setTooltiptext("Criar Registro");
		btnAdicionar.setIconSclass("z-icon-plus-circle");
		btnAdicionar.addEventListener(Events.ON_CLICK, this);
		barraFerramentas.appendChild(btnAdicionar);

		btnSair = new Toolbarbutton();
		btnSair.setTooltiptext("Sair");
		btnSair.setIconSclass("z-icon-sign-out-alt");
		btnSair.addEventListener(Events.ON_CLICK, this);
		barraFerramentas.appendChild(btnSair);

		Tabpanels abas = new Tabpanels();
		layoutAbas.appendChild(abas);

		Tabpanel aba = new Tabpanel();
		abas.appendChild(aba);

		Grid layoutTabela = new Grid();
		aba.appendChild(layoutTabela);

		Columns colunas = new Columns();
		colunas.setSizable(true);
		layoutTabela.appendChild(colunas);

		Rows linhas = new Rows();
		layoutTabela.appendChild(linhas);

		final String[] nomesColunas = new String[] { "Código", "Descrição", "Preço", "Quantidade", "Entradas", "Saídas",
				"", "", "" };

		for (String nomeColuna : nomesColunas) {
			Column coluna = new Column(nomeColuna);
			coluna.setAlign("center");
			colunas.appendChild(coluna);
		}

		for (int i = 1; i <= 5; i++) {
			Row linha = new Row();
			linhas.appendChild(linha);
			Label txt = new Label(String.valueOf(i));
			linha.appendChild(txt);
			txt = new Label("Produto de exemplo.");
			linha.appendChild(txt);
			txt = new Label("R$800.00,00");
			linha.appendChild(txt);
			txt = new Label("10");
			linha.appendChild(txt);
			txt = new Label("9");
			linha.appendChild(txt);
			txt = new Label("1");
			linha.appendChild(txt);
			Button btn = new Button("");
			btn.setTooltiptext("Exibir Imagem");
			btn.setId("btnExibirImagem_" + i);
			btn.setIconSclass("z-icon-camera");
			btn.addEventListener(Events.ON_CLICK, this);
			linha.appendChild(btn);
			btn = new Button("");
			btn.setTooltiptext("Editar");
			btn.setId("btnEditar_" + i);
			btn.addEventListener(Events.ON_CLICK, this);
			btn.setIconSclass("z-icon-edit");
			linha.appendChild(btn);
			btn = new Button("");
			btn.setTooltiptext("Excluir");
			btn.setId("btnExcluir_" + i);
			btn.setIconSclass("z-icon-trash");
			btn.addEventListener(Events.ON_CLICK, this);
			linha.appendChild(btn);
		}

		aba = new Tabpanel();
		abas.appendChild(aba);

		layoutTabela = new Grid();
		layoutTabela.setEmptyMessage("Não há registros");
		aba.appendChild(layoutTabela);

		aba = new Tabpanel();
		abas.appendChild(aba);

		layoutTabela = new Grid();
		layoutTabela.setEmptyMessage("Não há registros");
		aba.appendChild(layoutTabela);

		aba = new Tabpanel();
		abas.appendChild(aba);

		layoutTabela = new Grid();
		layoutTabela.setEmptyMessage("Não há registros");
		aba.appendChild(layoutTabela);

		aba = new Tabpanel();
		abas.appendChild(aba);

		layoutTabela = new Grid();
		layoutTabela.setEmptyMessage("Não há registros");
		aba.appendChild(layoutTabela);

	}

	@Override
	public void onEvent(Event event) throws Exception {
		String tipoEvento = event.getName();
		Component componenteDoEvento = event.getTarget();
		String id = componenteDoEvento.getId();

		if (tipoEvento.equals(Events.ON_CLICK)) {

			String mensagem = "Evento desconhecido!";
			if (componenteDoEvento.equals(btnConfigurar)) {
				mensagem = "Configurando";
			} else if (componenteDoEvento.equals(btnAdicionar)) {
				mensagem = "Adicionando";
			} else if (componenteDoEvento.equals(btnSair)) {
				Executions.getCurrent().sendRedirect("/index.zul");
				return;
			} else if (id.contains("btnExibirImagem_")) {
				mensagem = "Exibindo imagem";
			} else if (id.contains("btnEditar_")) {
				mensagem = "Editando";
			} else if (id.contains("btnExcluir_")) {
				mensagem = "Excluindo";
			}

			Messagebox.show(mensagem);

		}

	}
}
