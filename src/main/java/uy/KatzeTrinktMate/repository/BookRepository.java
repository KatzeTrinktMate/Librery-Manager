package uy.KatzeTrinktMate.repository;

import java.util.Map;
import java.util.List;
import java.util.Optional;
import uy.KatzeTrinktMate.model.Book;

public interface BookRepository {
    
    public Book addBook(Book newBook);

    public Book editBook(Long id, Book editBook);

    public List<Book> showBooks();

    public Map<Long, Book> bookForAuthor(String author);

    public Optional<Book> bookForISBN(String isbn);

    public Map<Long, Book> bookForTitle(String title);

    public boolean deleteBook(Long id);
}
