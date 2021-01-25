package searching;

import org.jetbrains.annotations.NotNull;

public class Book implements Comparable<Book> {

    private int id;
    private String title;
    private String author;

    public Book(int id, String author, String title) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(@NotNull Book o) {
        if (this.author.compareTo(o.author) == 0) {
            return this.title.compareTo(o.title);
        }
        return this.author.compareTo(o.author);
    }

    @Override
    public String toString() {
        return id + " " + author + " " + title;
    }
}
