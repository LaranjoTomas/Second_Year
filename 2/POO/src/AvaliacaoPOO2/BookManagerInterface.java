package AvaliacaoPOO2;

import java.time.LocalDate;
import java.util.List;

public interface BookManagerInterface {
    void load(String filePath);

    void save(String filePath);

    boolean validateISBN(String isbn);

    boolean addBook(Book book);

    boolean removeBook(Book book);

    Book searchByname(String name);

    List<Book> searchByAuthor(String author);

    List<Book> searchByDateInterval(LocalDate fromDate, LocalDate toDate);

    Book searchByISBN(String isbn);

    void listAllBooks();

    void listBooksByName();

    void listBooksByAuthor();

    void listBooksByDate();
}
