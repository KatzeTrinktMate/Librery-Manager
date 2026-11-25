package uy.KatzeTrinktMate.repository;

import java.util.List;
import java.util.Optional;
import uy.KatzeTrinktMate.model.Book;

public interface BookRepository {
    
    public Book addBook(Book newBook);

    public Book editBook(Long id, Book editBook);

    public List<Book> showBooks();

    public List<Book> bookForAuthor(String author);

    public Optional<Book> bookForISBN(String isbn);

    public Optional<Book> bookForId(Long id);

    public List<Book> bookForTitle(String title);

    public void deleteBook(Long id);
}
