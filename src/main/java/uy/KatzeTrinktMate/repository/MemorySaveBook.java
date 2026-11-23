package uy.KatzeTrinktMate.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import uy.KatzeTrinktMate.model.Book;

public class MemorySaveBook implements BookRepository {
    Map<Long, Book> bookStorage = new HashMap<>();

    @Override
    public Book addBook(Book newBook) {
        
        //  try {
        //      Long id = newBook.getId();
        //      if (id == null || id < 0 || !bookStorage.containsKey(id)) {
        //          throw new IllegalArgumentException("The book " + newBook.getTitle() + " is alredy exist");
        //      } else {
        //          bookStorage.put(newBook.getId(), newBook);
        //      }
        //  } catch (Exception e) {
        //      System.out.println("Something happend was error ->" + e);
        //  } finally {
        //      return newBook;
        //  }
        return newBook;
    }

    @Override
    public Book editBook(Long id, Book editBook) {
        throw new UnsupportedOperationException("Unimplemented method 'editBook'");
    }

    @Override
    public Map<Long, Book> showBooks() {
        // idk what return, but this show all books ñeje >:3
        return this.bookStorage;
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
        // for the moment i don't write nothing :P
        throw new UnsupportedOperationException("Unimplemented method 'bookForISBN'");
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
        if (delBook == null || id == null || id < 0) throw new IllegalArgumentException("Book invalid");
        if (bookStorage.containsKey(id)) throw new IllegalArgumentException("Book"+ delBook.getTitle() +" wasn't found");
        System.out.println("Book was deleted");
        return bookStorage.remove(id, delBook);
    }

}
