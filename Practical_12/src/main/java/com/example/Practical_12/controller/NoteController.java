package com.example.Practical_12.controller;

import com.example.Practical_12.model.Note;
import com.example.Practical_12.repository.NoteRepository;
import com.example.Practical_12.service.FileWriter.FileWriterService;
import com.example.Practical_12.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;
    private final FileWriterService fileWriterService;
    @Autowired
    public NoteController(NoteService noteService, FileWriterService fileWriterService) {
        this.noteService = noteService;
        this.fileWriterService = fileWriterService;
    }
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }
//    @PostMapping
//    public ResponseEntity<Note> createNote(@RequestBody Note note) {
//        fileWriterService.writeToFile(note.toString());
//        Note createdNote = noteService.createNote(note);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
//    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        fileWriterService.writeToFile(note.toString());
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }
}
