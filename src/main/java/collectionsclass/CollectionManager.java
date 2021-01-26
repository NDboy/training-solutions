package collectionsclass;

import java.util.Collections;
import java.util.List;

public class CollectionManager {

    private List<Book> library;

    public CollectionManager(List<Book> library) {
        this.library = library;
    }

    public List<Book> getLibrary() {
        return Collections.synchronizedList(library);
    }

    public List<Book> createUnmodifiableLibrary() {
        return Collections.unmodifiableList(library);
    }

    public List<Book> reverseLibrary() {
        List<Book> synchronizedList = getLibrary();
        Collections.reverse(synchronizedList);
        return synchronizedList;
    }

    public Book getFirstBook() {
        List<Book> synchronizedList = getLibrary();
        Collections.sort(synchronizedList);
        return synchronizedList.get(0);
    }

    public Book getLastBook() {
        List<Book> synchronizedList = getLibrary();
        Collections.sort(synchronizedList);
        Collections.reverse(synchronizedList);
        return synchronizedList.get(0);
    }



}
