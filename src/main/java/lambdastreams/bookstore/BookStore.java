package lambdastreams.bookstore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
//        return books.stream().reduce(0, (i, b) -> i + b.getAmount(), (i1, i2) -> i1 + i2);
        return books.stream().reduce(0, (i, b) -> i + b.getAmount(), Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparing(Book::getYearOfPublish));
    }

    public int getTotalValue () {
        return books.stream().reduce(0, (i, b) -> i + b.getPrice() * b.getAmount(), (i1, i2) -> i1 + i2);
    }


    public List<Book> getByYearOfPublish(int yearOfPublish) {
        return books.stream().collect(Collectors.groupingBy(Book::getYearOfPublish)).get(yearOfPublish);
    }
}
