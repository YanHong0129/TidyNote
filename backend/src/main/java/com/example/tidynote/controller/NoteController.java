package com.example.tidynote.controller;

import com.example.tidynote.entity.Note;
import com.example.tidynote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*") // Allow frontend on another port
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping // Get all notes using automatic SQL generation
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping // Save a new note mannually
    public Note addNote(@RequestBody Note note) {
        Note entity = new Note();
        entity.setTitle(note.getTitle());
        entity.setContent(note.getContent());
        noteRepository.save(entity);
        
        return entity;
    }

    @PutMapping("/{id}") // Update a note
    public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        Note note = getNoteById(id);
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteRepository.save(updatedNote);
    }

    @DeleteMapping("/{id}") // Delete a note
    public void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }

    @GetMapping("/{id}") // Get a note by ID
    public Note getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Note not found with id " + id));
    }
    
    
}
