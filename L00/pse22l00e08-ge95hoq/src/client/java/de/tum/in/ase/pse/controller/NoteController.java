package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Note;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NoteController {
	private final WebClient webClient;
	private final List<Note> notes;

	public NoteController() {
		this.webClient = WebClient.builder()
				.baseUrl("http://localhost:8080/")
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
		this.notes = new ArrayList<>();
	}

	public void addNote(Note note, Consumer<List<Note>> notesConsumer) {
		webClient.post()
				.uri("notes")
				.bodyValue(note)
				.retrieve()
				.bodyToMono(Note.class)
				.onErrorStop()
				.subscribe(newNote -> {
					notes.add(newNote);
					notesConsumer.accept(notes);
				});
	}

	public void editNote(Note note, Consumer<List<Note>> notesConsumer) {
		webClient.put()
				.uri("notes/" + note.getId())
				.bodyValue(note)
				.retrieve()
				.bodyToMono(Note.class)
				.onErrorStop()
				.subscribe(newNote -> {
					notes.replaceAll(oldNote -> oldNote.getId().equals(newNote.getId()) ? newNote : oldNote);
					notesConsumer.accept(notes);
				});
	}

	public void deleteNote(Note note, Consumer<List<Note>> notesConsumer) {
		webClient.delete()
				.uri("notes/" + note.getId())
				.retrieve()
				.toBodilessEntity()
				.onErrorStop()
				.subscribe(v -> {
					notes.remove(note);
					notesConsumer.accept(notes);
				});
	}

	public void getAllNotes(Consumer<List<Note>> notesConsumer) {
		webClient.get()
				.uri(uriBuilder -> uriBuilder
						.path("notes")
						.queryParam("secret", "SecretKey")
						.build())
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Note>>() {
				})
				.onErrorStop()
				.subscribe(newNotes -> {
					notes.clear();
					notes.addAll(newNotes);
					notesConsumer.accept(notes);
				});
	}
}
