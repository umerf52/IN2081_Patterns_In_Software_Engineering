package de.tum.in.ase.pse.model;

import java.time.Instant;
import java.util.UUID;

public class Note {
	private UUID id;
	private String name;
	private String content;
	private Instant creationDate;

	public Note() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Note{" +
				"id=" + id +
				", name='" + name + '\'' +
				", content='" + content + '\'' +
				", creationDate=" + creationDate +
				'}';
	}
}
