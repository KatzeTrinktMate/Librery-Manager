package uy.KatzeTrinktMate.repository;

public interface BookActions {
    public void addBook();

    public void editBook();

    public void showBooks();

    public void bookForAuthor(String author);

    public void bookForISBN(String isbn);

    public void bookForTitle(String title);

    public void deleteBook(Long id);
}
