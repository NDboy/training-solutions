package iofilestest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookList;

    public Library(List<Book> books) {
        bookList = books;
    }

    public List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }

    public boolean add(Book... books) {
        boolean done = false;
        for (Book book: books) {
            boolean contains = false;
            for (Book book2: bookList) {
                if (book.equals(book2)) {
                    contains = true;
                }
            }
            if (!contains) {
                bookList.add(book);
                done = true;
            }
        }
        return done;
    }

    public void saveBooks(Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)){
            for (Book book: bookList) {
                bw.write(book.toString() + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public List<Book> loadBooks(Path path) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line;
            while ((line = br.readLine()) != null) {
                String author = line.split("-")[0];
                String title = line.split("-")[1];
                books.add(new Book(author, title));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return books;
    }

}
