package de.tum.in.ase.pse.rest;

import de.tum.in.ase.pse.model.Note;
import de.tum.in.ase.pse.service.NoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class NoteResource {

	private final NoteService noteService;

	public NoteResource(NoteService noteService) {
		this.noteService = noteService;
	}

	@GetMapping("notes")
	public ResponseEntity<List<Note>> getAllNotes(@RequestParam("secret") String secret) {
		if (!"SecretKey".equals(secret)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(noteService.getAllNotes());
	}

	@PostMapping("notes")
	public ResponseEntity<Note> createNote(@RequestBody Note note) {
		if (note.getId() != null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(noteService.saveNote(note));
	}

	@PutMapping("notes/{noteId}")
	public ResponseEntity<Note> updateNote(@RequestBody Note updatedNote, @PathVariable("noteId") UUID noteId) {
		if (!updatedNote.getId().equals(noteId)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(noteService.saveNote(updatedNote));
	}

	@DeleteMapping("notes/{noteId}")
	public ResponseEntity<Void> deleteNote(@PathVariable("noteId") UUID noteId) {
		noteService.deleteNote(noteId);
		return ResponseEntity.noContent().build();
	}
}
