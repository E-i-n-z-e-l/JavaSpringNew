package com.example.Practical_12.service;

import com.example.Practical_12.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note createNote(Note note);
}
