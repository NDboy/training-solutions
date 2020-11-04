package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> titles = new ArrayList<>();

    public void addBook(String title) { titles.add(title);}

    public List<String> findAllByPrefix(String prefix) {
        List<String> findBook = new ArrayList<>();
        for (String t: titles) {
            if (t.startsWith(prefix)) {
                findBook.add(t);
            }
        }
        return findBook;
    }

    public List<String> getTitles() {
        return titles;
    }

    public static void main(String[] args) {
        Books books = new Books();
        books.addBook("A láthatatlan fény");
        books.addBook("Krsna");
        books.addBook("A lány két névvel");
        books.addBook("Háború a világ végén");
        books.addBook("A tetovált lány");
        books.addBook("Kés");

        System.out.println(books.getTitles());
        System.out.println(books.findAllByPrefix("A"));


    }
}
