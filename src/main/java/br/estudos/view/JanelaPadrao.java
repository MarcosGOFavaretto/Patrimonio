package br.estudos.view;

import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

public abstract class JanelaPadrao extends Window {

	private static final long serialVersionUID = -3046753120423526199L;

	private Window win = null;
	protected Vbox layoutVerticalDaJanela = null;
	protected Vbox layoutVerticalCentralizado = null;

	public JanelaPadrao(Window win, boolean isCentralizada) {
		this.setWindow(win);

		layoutVerticalDaJanela = new Vbox();
		layoutVerticalDaJanela.setWidth(ViewUtils.CEM_POR_CENTO);
		layoutVerticalDaJanela.setHeight(ViewUtils.CEM_POR_CENTO);

		if (isCentralizada) {
			layoutVerticalDaJanela.setAlign(ViewUtils.CENTRO);
			layoutVerticalDaJanela.setPack(ViewUtils.CENTRO);
		}

		this.appendChild(layoutVerticalDaJanela);

		layoutVerticalCentralizado = new Vbox();
		layoutVerticalCentralizado.setWidth(ViewUtils.CINQUENTA_POR_CENTO);
		layoutVerticalCentralizado.setHeight(ViewUtils.CEM_POR_CENTO);

		if (isCentralizada) {
			layoutVerticalCentralizado.setAlign(ViewUtils.CENTRO);
			layoutVerticalCentralizado.setPack(ViewUtils.CENTRO);
		}

		layoutVerticalDaJanela.appendChild(layoutVerticalCentralizado);

	}

	public Window getWindow() {
		return win;
	}

	public void setWindow(Window win) {
		this.win = win;
	}

}
