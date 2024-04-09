package com.example.Practical_12.service;

import com.example.Practical_12.model.Note;
import com.example.Practical_12.model.NoteFactory;
import org.springframework.stereotype.Service;

@Service
public class NoteFactoryImpl implements NoteFactory {
    @Override
    public Note createBlankNote() {
        return new Note();
    }
}

