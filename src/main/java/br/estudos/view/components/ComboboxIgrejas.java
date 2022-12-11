package br.estudos.view.components;

import org.zkoss.zul.Combobox;

public class ComboboxIgrejas extends Combobox {

	private static final long serialVersionUID = -6253405285315359490L;
	private static final int PRIMEIRA_OPCAO_DE_IGREJA = 0;

	public ComboboxIgrejas() {

		this.appendItem("Igreja 1");
		this.appendItem("Igreja 2");
		this.appendItem("Igreja 3");
		this.appendItem("Paróquia");
		this.setSelectedIndex(PRIMEIRA_OPCAO_DE_IGREJA);

	}

}
