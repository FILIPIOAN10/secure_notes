package secure_notes.secure_notes.service;

import secure_notes.secure_notes.models.Note;

import java.util.List;

public interface NoteService {
    Note createNoteForUser(String username,String content);
    Note updateNoteForUser(Long noteId,String content,String username);
    void  deleteNoteForUser(Long noteId,String username);
    List<Note> getNotesForUser(String username);
}
