package br.estudos.view;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Window;

public class ViewUtils {

	/** Constantes */
	public static final String CEM_POR_CENTO = "100%";
	public static final String CINQUENTA_POR_CENTO = "50%";
	public static final String CENTRO = "center";

	/**
	 * Este m�todo ir� obter todos os componentes filhos da janela e remov�-los.
	 * 
	 * @param janela: deve ser informada a janela que ter� seus itens removidos.
	 * @return "true" se a janela n�o possuir mais filhos e "false" caso possua.
	 */
	public static boolean removerItensDaJanela(Window janela) {

		if (janela == null)
			return false;

		List<Component> componentes = janela.getChildren();
		componentes.clear();

		if (componentes.size() == 0)
			return true;

		return false;
	}

	/**
	 * Este m�todo ir� verificar se o texto informado possui informa��es.
	 * 
	 * @param texto: � a String que deve ser analisada.
	 * @return "true" caso o texto seja diferente de "null", a quantidade de
	 *         caracteres seja maior que zero e isBlank seja false.
	 */
	public static boolean isStringVazia(String texto) {
		return (texto == null || texto.isBlank() || texto.length() <= 0);
	}
}
