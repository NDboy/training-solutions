package sorting;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private int id;
    private String author;
    private String title;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author.trim();
    }

    public String getTitle() {
        return title.trim();
    }

    @Override
    public int compareTo(@NotNull Book o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return id + " " + author.trim() + " " + title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
