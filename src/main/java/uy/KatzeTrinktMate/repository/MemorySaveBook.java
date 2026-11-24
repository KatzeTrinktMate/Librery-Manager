package uy.KatzeTrinktMate.repository;

import java.lang.classfile.ClassFile.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import uy.KatzeTrinktMate.model.Book;

public class MemorySaveBook implements BookRepository {
    Map<Long, Book> bookStorage = new HashMap<>();

    @Override
    public Book addBook(Book newBook) {
        if (newBook == null) 
            throw new IllegalArgumentException ("Book can't be null");
        Long id = newBook.getId();
        if (id == null || id < 0)
            throw new IllegalArgumentException ("Book can't be null");
        //the putIfAbsent is a method check if the Data is not alredy exist, if id no exist, use the .put method 
        if (bookStorage.putIfAbsent(id, newBook) != null) {
            throw new IllegalArgumentException("The book already exists");
        }
        return newBook;
    }

    @Override
    public Book editBook(Long id, Book editBook) {
        throw new UnsupportedOperationException("Unimplemented method 'editBook'");
    }

    @Override
    public List<Book> showBooks() {
        return new ArrayList<>(bookStorage.values()); //:3
    }

    @Override
    public List<Book> bookForAuthor(String author) {
        List<Book> authors = new ArrayList<>();
        for (Book temBook : bookStorage.values()) {
            if (temBook.getAuthor().equalsIgnoreCase(author))
                authors.add(temBook);
        }
        return authors;
    }

    @Override
    public Optional<Book> bookForISBN(String isbn) {
        for (Book searchBook : bookStorage.values()) {
            if (Objects.equals(searchBook.getIsbn(), isbn))
                return Optional.of(searchBook);
        }
        return Optional.empty();
    }

    @Override
    public List<Book> bookForTitle(String title) {
        List<Book> titleBooks = new ArrayList<>();
        for (Book tempBook : bookStorage.values()) {
            if (tempBook.getTitle().equalsIgnoreCase(title))
                titleBooks.add(tempBook);
        }
        return titleBooks;
    }

    @Override
    public boolean deleteBook(Book delBook) {
        Long id = delBook.getId();
        if (delBook == null || id == null || id < 0)
            throw new IllegalArgumentException("Book invalid");
        if (bookStorage.containsKey(id))
            throw new IllegalArgumentException("Book" + delBook.getTitle() + " wasn't found");
        System.out.println("Book was deleted");
        return bookStorage.remove(id, delBook);
    }

}
