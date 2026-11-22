package uy.KatzeTrinktMate.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import uy.KatzeTrinktMate.model.Book;

public class MemorySaveBook implements BookRepository {
    Map<Long, Book> bookStorage = new HashMap<>();
    List authors = new ArrayList<>();
    List titleBooks = new ArrayList<>();
    
    @Override
    public Book addBook(Long id, Book newBook) {
        try {
            if (id == null || newBook == null) throw new NullPointerException(); 
            bookStorage.put(id, newBook);
        } catch (Exception e) {
            System.out.println("Something error was happend ->" + e);
        } finally{
        return newBook;
        }
    }

    @Override
    public Book editBook(Long id, Book editBook) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editBook'");
    }

    @Override
    public Map<Long, Book> showBooks() {
        return this.bookStorage;
    }

    @Override
    public List<Book> bookForAuthor(String author) {
    for (Book temBook : bookStorage.values()) {
        if (temBook.getAuthor() != author) {
            continue;
        }else{
            authors.add(temBook);
        }
    }
    return authors;
    }

    @Override
    public Optional<Book> bookForISBN(String isbn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bookForISBN'");
    }

    @Override
    public List<Book> bookForTitle(String title) {
        for (Book temBook : bookStorage.values()) {
            if (temBook.getTitle() != title) {
                continue;
            }else{
                titleBooks.add(temBook);
            }
        }
        return titleBooks;
    }

    @Override
    public boolean deleteBook(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }
    
}
