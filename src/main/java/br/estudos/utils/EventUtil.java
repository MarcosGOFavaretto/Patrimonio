package br.estudos.utils;

import java.security.InvalidParameterException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

public class EventUtil {

	private String eventType;
	private Component cmp;

	public EventUtil(Event zkEvent) {

		if (zkEvent == null)
			throw new InvalidParameterException("The event needs to be provided!");

		this.cmp = zkEvent.getTarget();
		this.eventType = zkEvent.getName();
	}

	public boolean isOnClick() {
		return this.eventType.equals(Events.ON_CLICK);
	}

	public boolean isOnUpload() {
		return this.eventType.equals(Events.ON_UPLOAD);
	}

	public boolean isSameComponent(Component cmp) {
		return this.cmp.getId().equals(cmp.getId());
	}
}
