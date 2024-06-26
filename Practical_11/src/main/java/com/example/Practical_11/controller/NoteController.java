package com.example.Practical_11.controller;

import com.example.Practical_11.model.Note;
import com.example.Practical_11.service.NoteService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class NoteController {
    private final NoteService noteService;
    private final Counter requestCounter = Metrics.counter("request_count");
    private final Counter requestCounter2 = Metrics.counter("request_count");
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        requestCounter.increment();
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable Long id, @RequestBody Note updatedNote) {
        Note note = noteService.updateNoteById(id, updatedNote);
        if (note != null) {
            return ResponseEntity.ok(note);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        requestCounter2.increment();
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
