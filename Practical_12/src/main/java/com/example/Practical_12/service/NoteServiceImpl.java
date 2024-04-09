package com.example.Practical_12.service;

import com.example.Practical_12.model.Note;
import com.example.Practical_12.model.NoteFactory;
import com.example.Practical_12.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    private final NoteFactory noteFactory;

    public NoteServiceImpl(NoteRepository noteRepository, NoteFactory noteFactory) {
        this.noteRepository = noteRepository;
        this.noteFactory = noteFactory;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    @Override
    public Note createNote(Note note) {
        Note blankNote = noteFactory.createBlankNote();
        // Копируем значения из переданной заметки
        blankNote.setTitle(note.getTitle());
        blankNote.setContent(note.getContent());
        return noteRepository.save(blankNote);
    }
}
