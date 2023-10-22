package de.tum.in.ase.pse.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private static final long serialVersionUID = 8966157877771255818L;
	private String message;

	public ChatMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
