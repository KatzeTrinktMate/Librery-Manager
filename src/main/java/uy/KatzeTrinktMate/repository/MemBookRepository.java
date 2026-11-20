package uy.KatzeTrinktMate.repository;

public interface BookRepository {
    public Book addBook(Long id);

    public Book editBook(Long id, Book newBook);

    public List<Book> showBooks();

    public Optional<Book> bookForAuthor(String author);

    public Optional<Book> bookForISBN(String isbn);

    public Optional<Book> bookForTitle(String title);

    public boolean deleteBook(Long id);
}
