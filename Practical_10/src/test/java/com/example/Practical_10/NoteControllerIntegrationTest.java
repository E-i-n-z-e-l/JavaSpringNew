package com.example.Practical_10;

import com.example.Practical_10.controller.NoteController;
import com.example.Practical_10.model.Note;
import com.example.Practical_10.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

@WebMvcTest(NoteController.class)
@AutoConfigureMockMvc
public class NoteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NoteService noteService;

    @Test
    public void testGetAllNotes() throws Exception {
        List<Note> expectedNotes = new ArrayList<>();
        expectedNotes.add(new Note());
        expectedNotes.add(new Note());

        when(noteService.getAllNotes()).thenReturn(expectedNotes);

        mockMvc.perform(get("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title 1"))
                .andExpect(jsonPath("$[0].content").value("Content 1"))
                .andExpect(jsonPath("$[1].title").value("Title 2"))
                .andExpect(jsonPath("$[1].content").value("Content 2"));

        verify(noteService, times(1)).getAllNotes();
    }
}

