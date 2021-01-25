package collectionscomp;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {
    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> getLibraryBooks() {
        return new ArrayList<>(libraryBooks);
    }

    public List<Book> orderedByTitle() {
        List<Book> orderedList = new ArrayList<>(libraryBooks);
        Collections.sort(orderedList);
        return orderedList;
    }


    public List<Book> orderedByAuthor() {
        List<Book> orderedList = new ArrayList<>(libraryBooks);
        Collections.sort(orderedList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        return orderedList;
    }


    public List<String> orderedByTitleLocale(Locale locale) {
        List<Book> orderedList = new ArrayList<>(libraryBooks);
        List<String> orderedTitleList = new ArrayList<>();
        for (Book book: orderedList) {
            orderedTitleList.add(book.getTitle());
        }
        Collections.sort(orderedTitleList, Collator.getInstance(locale));
        return orderedTitleList;
    }

}
