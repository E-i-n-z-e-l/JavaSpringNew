package com.example.Practical_10.service;

import com.example.Practical_10.model.Note;
import com.example.Practical_10.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        return noteOptional.orElse(null);
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNoteById(Long id, Note updatedNote) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note existingNote = noteOptional.get();
            existingNote.setTitle(updatedNote.getTitle());
            existingNote.setContent(updatedNote.getContent());
            return noteRepository.save(existingNote);
        } else {
            return null;
        }
    }

    @Override
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}

