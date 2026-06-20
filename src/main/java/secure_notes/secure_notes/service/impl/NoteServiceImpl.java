package secure_notes.secure_notes.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import secure_notes.secure_notes.models.Note;
import secure_notes.secure_notes.repository.NoteRepository;
import secure_notes.secure_notes.service.NoteService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {


    private final NoteRepository noteRepository;
    @Override
    public Note createNoteForUser(String username, String content) {
        Note note= new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        Note savedNote = noteRepository.save(note);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String username) {
        Note note = noteRepository.findById(noteId).orElseThrow(()->new RuntimeException());
        note.setContent(content);
        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @Override
    public void deleteNoteForUser(Long noteId, String username) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesForUser(String username) {
        List<Note> personalNotes = noteRepository.findByOwnerUsername(username);
        return personalNotes;
    }
}
