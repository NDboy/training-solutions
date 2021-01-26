package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class OrderedLibrary {

    private Set<Book> library;

    public OrderedLibrary(Set<Book> library) {
        this.library = library;
    }

    public Book lendFirstBook() {
        if (library.isEmpty() || library == null) {
            throw new NullPointerException("Libray is empty!");
        }
        List<Book> bookList = new ArrayList<>(library);
        Collections.sort(bookList);
        return bookList.get(0);
    }
}
