package de.tum.in.ase.pse.service;

import de.tum.in.ase.pse.model.Note;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class NoteService {
	private final List<Note> notes;

	public NoteService() {
		this.notes = new ArrayList<>();
	}

	public Note saveNote(Note note) {
		var optionalNote = notes.stream().filter(existingNote -> existingNote.getId().equals(note.getId())).findFirst();
		if (optionalNote.isEmpty()) {
			note.setId(UUID.randomUUID());
			note.setCreationDate(Instant.now());
			notes.add(note);
			return note;
		} else {
			var existingNote = optionalNote.get();
			existingNote.setName(note.getName());
			existingNote.setContent(note.getContent());
			return existingNote;
		}
	}

	public void deleteNote(UUID noteId) {
		this.notes.removeIf(note -> note.getId().equals(noteId));
	}

	public List<Note> getAllNotes() {
		return Collections.unmodifiableList(this.notes);
	}
}
