package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class OrderedArrayLibrary {

    private Book[] bookArray;

    public OrderedArrayLibrary(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] sortingById() {
        Book[] books = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(books);
        return books;
    }

    public Book[] sortingByTitle() {
        Book[] books = Arrays.copyOf(bookArray, bookArray.length);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return books;
    }


}
