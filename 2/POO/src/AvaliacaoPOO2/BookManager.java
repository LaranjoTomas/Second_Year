package AvaliacaoPOO2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BookManager implements BookManagerInterface {

    List<Book> books = new ArrayList<>();

    public BookManager() {
    }

    public void load(String filePath) {

        try {
            FileReader File = new FileReader(filePath);
            BufferedReader FileBuffed = new BufferedReader(File);
            String line = FileBuffed.readLine();

            while ((line = FileBuffed.readLine()) != null) {
                String[] fields = line.split("\t");
                String name = fields[0];
                String publisher = fields[1];
                String author = fields[2];
                String isbn = fields[3];
                LocalDate releaseDate = LocalDate.parse(fields[4]);

                Book book = new Book(name, publisher, author, isbn, releaseDate);
                books.add(book);

                line = FileBuffed.readLine();
            }

            FileBuffed.close();
            File.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }

    }

    public void save(String filePath) {
        try {
            FileWriter File = new FileWriter(filePath);
            BufferedWriter FileBuffed = new BufferedWriter(File);
            for (Book book : books) {
                FileBuffed.write(book.getName() + "\t" + book.getPublisher() + "\t" + book.getAuthor() + "\t"
                        + book.getIsbn() + "\t" + book.getReleaseDate());
                FileBuffed.newLine();
            }

            FileBuffed.close();
            File.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public boolean validateISBN(String isbn) {
        int count = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (isbn.charAt(i) != '-') {
                // check if its a number
                if (isbn.matches("[0-9]+")) {
                    return false;
                }
                count++;
            }
        }

        // considerei que o isbn pode ter 10 ou 13 digitos
        if (count != 13 || count != 10) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addBook(Book book) {
        if (validateISBN(book.getIsbn())) {
            books.add(book);
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book) {
        if (validateISBN(book.getIsbn())) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public Book searchByname(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                return books;
            }
        }
        return null;
    }

    public List<Book> searchByDateInterval(LocalDate fromDate, LocalDate toDate) {
        for (Book book : books) {
            if (book.getReleaseDate().isAfter(fromDate) && book.getReleaseDate().isBefore(toDate)) {
                return books;
            }
        }
        return null;
    }

    public Book searchByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void listBooksByName() {
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }

    public void listBooksByAuthor() {
        for (Book book : books) {
            System.out.println(book.getAuthor());
        }
    }

    public void listBooksByDate() {
        for (Book book : books) {
            System.out.println(book.getReleaseDate());
        }
    }
}
