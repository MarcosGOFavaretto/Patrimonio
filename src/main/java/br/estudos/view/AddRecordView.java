package br.estudos.view;

import org.zkoss.image.Image;
import org.zkoss.util.media.Media;
import org.zkoss.zhtml.Fileupload;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Button;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Space;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;

import br.estudos.utils.EventUtil;

public class AddRecordView extends Window implements EventListener<Event> {

	private static final long serialVersionUID = 1650461945038468010L;

	/** Components */
	Textbox txtName = null;
	Doublebox txtUniquePrice = null;
	Doublebox txtQuantity = null;
	Doublebox txtOutput = null;
	Doublebox txtDestination = null;
	Doublebox txtDecrease = null;
	
	Button btnCreate = null;
	Button btnCancel = null;
	Fileupload imageUploader = null;

	public AddRecordView() {
		this.setPosition("parent");
		this.setVisible(false);
		this.setWidth("20%");
		this.setBorder("normal");
		this.setPosition("center, center");
		this.setClosable(true);
		this.setPage(Executions.getCurrent().getDesktop().getFirstPage());

		Hbox mainLayout = new Hbox();
		mainLayout.setParent(this);
		mainLayout.setWidth(ViewUtils.CEM_POR_CENTO);
		mainLayout.setHeight(ViewUtils.CEM_POR_CENTO);
		mainLayout.setAlign(ViewUtils.CENTRO);
		mainLayout.setPack(ViewUtils.CENTRO);

		Vbox fieldsLayout = new Vbox();
		fieldsLayout.setParent(mainLayout);
		fieldsLayout.setAlign(ViewUtils.CENTRO);
		fieldsLayout.setPack(ViewUtils.CENTRO);

		Label lblFields = new Label("Preencha os campos");
		lblFields.setParent(fieldsLayout);

		// Fields
		txtName = new Textbox();
		txtName.setPlaceholder("Nome do item");
		txtName.setParent(fieldsLayout);

		txtUniquePrice = new Doublebox();
		txtUniquePrice.setWidth(ViewUtils.CEM_POR_CENTO);
		txtUniquePrice.setPlaceholder("Valor unitário");
		txtUniquePrice.setParent(fieldsLayout);

		txtQuantity = new Doublebox();
		txtQuantity.setWidth(ViewUtils.CEM_POR_CENTO);
		txtQuantity.setPlaceholder("Quantidade");
		txtQuantity.setParent(fieldsLayout);

		txtOutput = new Doublebox();
		txtOutput.setWidth(ViewUtils.CEM_POR_CENTO);
		txtOutput.setPlaceholder("Saída");
		txtOutput.setParent(fieldsLayout);

		txtDestination = new Doublebox();
		txtDestination.setWidth(ViewUtils.CEM_POR_CENTO);
		txtDestination.setPlaceholder("Destino");
		txtDestination.setParent(fieldsLayout);

		txtDecrease = new Doublebox();
		txtDecrease.setWidth(ViewUtils.CEM_POR_CENTO);
		txtDecrease.setPlaceholder("Baixa");
		txtDecrease.setParent(fieldsLayout);

		fieldsLayout.appendChild(new Space());

		Label lblImage = new Label("Envie a imagem");
		lblImage.setParent(fieldsLayout);

		imageUploader = new Fileupload();
		imageUploader.setIconSclass("z-icon-camera");
		imageUploader.setWidth(ViewUtils.CINQUENTA_POR_CENTO);
		imageUploader.setHeight(ViewUtils.CINQUENTA_POR_CENTO);
		imageUploader.setParent(fieldsLayout);
		imageUploader.addEventListener(Events.ON_UPLOAD, this);
		imageUploader.setId("imageUploader");

		fieldsLayout.appendChild(new Space());

		// Buttons.
		Hbox buttonsLayout = new Hbox();
		buttonsLayout.setAlign(ViewUtils.CENTRO);
		buttonsLayout.setPack(ViewUtils.CENTRO);
		buttonsLayout.setParent(fieldsLayout);

		btnCreate = new Button("Criar");
		btnCreate.addEventListener(Events.ON_CLICK, this);
		btnCreate.setId("btnCreate");
		btnCreate.setParent(buttonsLayout);
		btnCancel = new Button("Cancelar");
		btnCancel.setId("btnCancel");
		btnCancel.addEventListener(Events.ON_CLICK, this);
		btnCancel.setParent(buttonsLayout);

	}

	@Override
	public void onEvent(Event event) throws Exception {
		EventUtil evt = new EventUtil(event);

		if (evt.isOnClick()) {

			if (evt.isSameComponent(btnCreate)) {
				Messagebox.show("Item criado!");

				txtName.setValue("");
				txtUniquePrice.setValue(null);
				txtQuantity.setValue(null);
				txtOutput.setValue(null);
				txtDestination.setValue(null);
				txtDecrease.setValue(null);

			} else if (evt.isSameComponent(btnCancel)) {
				this.detach();
			}

		} else if (evt.isOnUpload()) {

			if (evt.isSameComponent(imageUploader)) {
				UploadEvent upEvent = (UploadEvent) event;
				Media file = upEvent.getMedia();

				if (file instanceof Image) {
					Messagebox.show("Arquivo enviado!");
				} else {
					Messagebox.show("O arquivo não é uma imagem!");
				}

			}

		}

	}

}
