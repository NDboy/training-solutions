package iofilestest;

public class Book {
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public boolean equals(Book book) {
        return this.getAuthor().equals(book.getAuthor()) && this.getTitle().equals(book.getTitle());
    }

    @Override
    public String toString() {
        return author + "-" + title;
    }
}
