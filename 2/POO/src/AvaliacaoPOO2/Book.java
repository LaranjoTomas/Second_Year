package AvaliacaoPOO2;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private String isbn;
    private LocalDate releaseDate;

    public Book(int id, String name, String author, String publisher, String isbn, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
    }

    public Book(String name, String publisher, String author, String isbn, LocalDate releaseDate) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String setAuthor(String author) {
        return this.author = author;
    }

    public String setPublisher(String publisher) {
        return this.publisher = publisher;
    }

    public String setIsbn(String isbn) {
        return this.isbn = isbn;
    }

    public LocalDate setReleaseDate(LocalDate releaseDate) {
        return this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", author='" + author + ", publisher='" + publisher
                + ", isbn='" + isbn + ", releaseDate=" + releaseDate + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.id == book.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
