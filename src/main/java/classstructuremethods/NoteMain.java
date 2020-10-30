package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {

        Note note = new Note();
        note.setName("Karsai Endre");
        note.setTopic("Teendőim");
        note.setText("hétfőn szervíz!");


        System.out.println(note.getNoteText());

    }
}
