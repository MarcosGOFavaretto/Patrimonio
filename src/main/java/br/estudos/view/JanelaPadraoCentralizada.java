package br.estudos.view;

import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

public abstract class JanelaPadraoCentralizada extends Window {

	private static final long serialVersionUID = -3046753120423526199L;

	private Window win = null;
	protected Vbox layoutVerticalDaJanela = null;
	protected Vbox layoutVerticalCentralizado = null;

	public JanelaPadraoCentralizada(Window win) {
		this.setWindow(win);

		layoutVerticalDaJanela = new Vbox();
		layoutVerticalDaJanela.setWidth(ViewUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.setHeight(ViewUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.setAlign(ViewUtils.CENTRO);
		layoutVerticalDaJanela.setPack(ViewUtils.CENTRO);
		this.appendChild(layoutVerticalDaJanela);

		layoutVerticalCentralizado = new Vbox();
		layoutVerticalCentralizado.setWidth(ViewUtils.CINQUENTA_POR_CENTO);
		layoutVerticalCentralizado.setHeight(ViewUtils.CEM_POR_CENTO);
		layoutVerticalCentralizado.setAlign(ViewUtils.CENTRO);
		layoutVerticalCentralizado.setPack(ViewUtils.CENTRO);
		layoutVerticalDaJanela.appendChild(layoutVerticalCentralizado);

	}

	public Window getWindow() {
		return win;
	}

	public void setWindow(Window win) {
		this.win = win;
	}

}
