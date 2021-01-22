package collectionsiterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {

    private Set<Book> libraryBooks;

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Set<Book> getLibraryBooks() {
        return new HashSet<>(libraryBooks);
    }

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> bookIterator = libraryBooks.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if (nextBook.getRegNumber() == regNumber) {
                return nextBook;
            }
        }
        throw new MissingBookException(String.format("No books found with regnumber: %d", regNumber));
    }

    public int removeBookByRegNumber(int regNumber) {
        Iterator<Book> bookIterator = libraryBooks.iterator();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if (nextBook.getRegNumber() == regNumber) {
                bookIterator.remove();
                return regNumber;
            }
        }
        throw new MissingBookException(String.format("No books found with regnumber: %d", regNumber));
    }


    public int libraryBooksCount() {
        return getLibraryBooks().size();
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Iterator<Book> bookIterator = libraryBooks.iterator();
        Set<Book> foundBooks = new HashSet<>();
        while (bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if (nextBook.getAuthor().equals(author)) {
                foundBooks.add(nextBook);
            }
        }
        if (foundBooks.isEmpty()) {
            throw new MissingBookException(String.format("No books found by %s", author));
        }
        return foundBooks;
    }
}
