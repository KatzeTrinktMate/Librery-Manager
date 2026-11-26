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
    
    @Override
    public Book editBook(Long id, Book editBook) {
        if (id == null || id <= 0) 
            throw new IllegalArgumentException ("Invalid book ID");
        if (editBook == null) 
            throw new IllegalArgumentException("Book data can't be null");
        
        Book oldBook = bookStorage.get(id);
        if (oldBook == null)
            throw new NoSuchElementException("The Book with id:" + id + " does not exist");

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
            throw new IllegalArgumentException ("Search author of book can't be empty");
        for (Book temBook : bookStorage.values()) {
            if (temBook.getAuthor().toLowerCase().contains(author.trim().toLowerCase()))
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

    //this method is for use other methods
    @Override 
    public Optional<Book> bookForId(Long id){
        return Optional.ofNullable(bookStorage.get(id));
    }

    @Override
    public List<Book> bookForTitle(String title) {
        List<Book> titleBooks = new ArrayList<>();
        if (title == null || title.isBlank()) 
            throw new IllegalArgumentException ("Search text of book can't be empty");
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
            throw new NoSuchElementException("Book wasn't found");
            
        bookStorage.remove(id, delBook);
    }

}
