package iofilestest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @TempDir
    public File folder;

    @Test
    void testGetBookList() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Anthony Doerr", "A láthatatlan fény"));
        bookList.add(new Book("Pak Janmi", "Élni akartam"));
        bookList.add(new Book("Bill Bryson", "Bájos szavak"));
        bookList.add(new Book("Edith Eva Eger", "Az ajándék"));
        bookList.add(new Book("Kepes András", "A boldog hülye és az okos depressziós"));
        Library library = new Library(bookList);
        assertEquals(5, library.getBookList().size());
        assertEquals("Pak Janmi", library.getBookList().get(1).getAuthor());
    }

    @Test
    void testAdd() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Anthony Doerr", "A láthatatlan fény"));
        bookList.add(new Book("Pak Janmi", "Élni akartam"));
        bookList.add(new Book("Bill Bryson", "Bájos szavak"));
        bookList.add(new Book("Edith Eva Eger", "Az ajándék"));
        bookList.add(new Book("Kepes András", "A boldog hülye és az okos depressziós"));
        Library library = new Library(bookList);
        assertEquals(5, library.getBookList().size());
        library.add(new Book("George Orwell", "1984"));
        assertEquals(6, library.getBookList().size());
        assertEquals("1984", library.getBookList().get(5).getTitle());

        assertFalse(library.add(new Book("George Orwell", "1984")));

    }

    @Test
    void testSaveAndLoadBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Anthony Doerr", "A láthatatlan fény"));
        bookList.add(new Book("Pak Janmi", "Élni akartam"));
        bookList.add(new Book("Bill Bryson", "Bájos szavak"));
        bookList.add(new Book("Edith Eva Eger", "Az ajándék"));
        bookList.add(new Book("Kepes András", "A boldog hülye és az okos depressziós"));
        Library library = new Library(bookList);
        Path path = Path.of("test.txt");
        library.saveBooks(folder.toPath().resolve(path));
        List<Book> loadedList = library.loadBooks(folder.toPath().resolve(path));
        assertEquals(bookList.size(), loadedList.size());
        assertEquals(bookList.get(3).toString(), loadedList.get(3).toString());
    }


}