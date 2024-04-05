package com.example.Practical_10;

import com.example.Practical_10.model.Note;
import com.example.Practical_10.repository.NoteRepository;
import com.example.Practical_10.service.NoteServiceImpl;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NoteServiceImplTest {

    private NoteServiceImpl noteService;
    private NoteRepository noteRepository;

    @BeforeEach
    public void setUp() {
        noteRepository = mock(NoteRepository.class);
        noteService = new NoteServiceImpl(noteRepository);
    }
    @Test
    public void testGetAllNotes() {
        List<Note> expectedNotes = new ArrayList<>();
        expectedNotes.add(new Note());
        expectedNotes.add(new Note());

        when(noteRepository.findAll()).thenReturn(expectedNotes);
        List<Note> actualNotes = noteService.getAllNotes();

        assertEquals(expectedNotes, actualNotes);
        verify(noteRepository, times(1)).findAll();
    }
}


