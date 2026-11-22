package uy.KatzeTrinktMate.repository;

import java.util.Map;
import java.util.List;
import java.util.Optional;
import uy.KatzeTrinktMate.model.Book;

public interface BookRepository {
    
    public Book addBook(Long id, Book newBook);

    public Book editBook(Long id, Book editBook);

    public Map<Long, Book> showBooks();

    public List<Book> bookForAuthor(String author);

    public Optional<Book> bookForISBN(String isbn);

    public List<Book> bookForTitle(String title);

    public boolean deleteBook(Long id);
}
