import java.util.ArrayList;

public class CaseFile {

    private ArrayList<String> notes;

    public CaseFile() {
        notes = new ArrayList<>();
    }

    public void addNote(String note) {
        if (note != null && !note.isEmpty()) {
            notes.add(note);
            System.out.println("Note added.");
        } else {
            System.out.println("Error: note cannot be empty.");
        }
    }

    public void showNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            for (String note : notes) {
                System.out.println("- " + note);
            }
        }
    }

    public int getNotesCount() {
        return notes.size();
    }
}