package uy.KatzeTrinktMate.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import uy.KatzeTrinktMate.model.Book;

public class MemorySaveBook implements BookRepository {
    private final Map<Long, Book> bookStorage = new HashMap<>();

    //putIfAbsent only adds the book if the id is not already used
    @Override
    public Book addBook(Book newBook) {
        if (newBook == null) 
            throw new IllegalArgumentException ("Book can't be null");
        Long id = newBook.getId();
        if (id == null || id <= 0)
            throw new IllegalArgumentException ("Invalid book data");
        if (bookStorage.putIfAbsent(id, newBook) != null) {
            throw new IllegalArgumentException("The book already exists");
        }
        return newBook;
    }

    //solo me falta este nama :P
    @Override
    public Book editBook(Long id, Book editBook) {
        if (id == null || id <= 0) 
            throw new IllegalArgumentException ("Invalid book ID");
        if (editBook == null) 
            throw new IllegalArgumentException("Book data can't be null");
        
        Book oldBook = bookStorage.get(id);
        if (oldBook == null)
            throw new NoSuchElementException("The Book " + editBook.getTitle() + "does not exist");
        if (Objects.equals(editBook, oldBook)){
            return oldBook;
        }
        //We confirm that the id used is for the edited book
        editBook.setId(id);
        bookStorage.put(id, editBook);
            
        return editBook;
    }

    @Override
    public List<Book> showBooks() {
        return new ArrayList<>(bookStorage.values()); //:3
    }

    @Override
    public List<Book> bookForAuthor(String author) {
        List<Book> authors = new ArrayList<>();
        if (author == null || author.isBlank())
            throw new IllegalArgumentException ("Book wasn't found");
        for (Book temBook : bookStorage.values()) {
            if (temBook.getAuthor().toLowerCase().contains(author))
                authors.add(temBook);
        }
        return authors;
    }

    //here, check if a book alredy exist (not how many much there are)
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
        if (title == null || title.isBlank()) 
            throw new IllegalArgumentException ("Book wasn't found");
        for (Book tempBook : bookStorage.values()) {
            if (tempBook.getTitle().toLowerCase().contains(title.trim().toLowerCase()))
                titleBooks.add(tempBook);
        }
        return titleBooks;
    }

    
    @Override
    public void deleteBook(Long id) {
        if (id == null || id <= 0)
            throw new IllegalArgumentException("Book invalid");
        Book delBook = bookStorage.get(id);
        if (delBook == null)
            throw new IllegalArgumentException("Book wasn't found");
            
        bookStorage.remove(id, delBook);
    }

}
