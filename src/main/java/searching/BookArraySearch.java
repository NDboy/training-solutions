package searching;

import java.util.Arrays;

public class BookArraySearch {

    private Book[] bookArray;

    public BookArraySearch(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public Book[] getBookArray() {
        return bookArray;
    }

    private boolean isEmpty (String str) {
        return str == null || str.isBlank();
    }

    public Book findBookByAuthorTitle(String author, String title) {
        Book[] copyArray = Arrays.copyOf(bookArray, bookArray.length);
        if (isEmpty(author) || isEmpty(title)) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        Arrays.sort(copyArray);
        int number = Arrays.binarySearch(copyArray, new Book(0, author, title));
        if (number < 0) {
            throw new IllegalArgumentException(String.format("No book found by %s with title %s", author, title));
        }
        return copyArray[number];
    }
}
