package com.example.Practical_11.service;

import com.example.Practical_11.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note createNote(Note note);
    Note updateNoteById(Long id, Note updatedNote);
    void deleteNoteById(Long id);
}
