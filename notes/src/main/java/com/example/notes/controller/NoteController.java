package com.example.notes.controller;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*")
public class NoteController {

	private final NoteRepository repository;

	public NoteController(NoteRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Note> getAllNotes() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
		return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Note createNote(@RequestBody Note note) {
		System.out.println(note.toString());
		return repository.save(note);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
		return repository.findById(id).map(note -> {
			note.setTitle((updatedNote).getTitle());
			note.setContent(updatedNote.getContent());
			return ResponseEntity.ok(repository.save(note));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
		return repository.findById(id).map(note -> {
			repository.delete(note);
			return ResponseEntity.noContent().<Void>build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/share/{id}")
	public ResponseEntity<Note> shareNote(@PathVariable Long id) {
		Optional<Note> note = repository.findById(id);
		return note.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
