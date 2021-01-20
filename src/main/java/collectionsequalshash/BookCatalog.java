package collectionsequalshash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookCatalog {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        Book searchedBook = new Book(title, author);
        for (Book book: books) {
            if (searchedBook.equals(book)) {
                return book;
            }
        }
        return null;
    }


    public Book findBook(List<Book> books, Book searchingFor) {
        for (Book book: books) {
            if (searchingFor.equals(book)) {
                return book;
            }
        }
        return null;
    }

    public Set<Book> addBooksToSet(Book[] sameBooks) {
        Set<Book> books = new HashSet<>();
        for (Book book: sameBooks) {
            if (!books.contains(book)) {
                    books.add(book);
            }
        }
        return books;
    }
}
