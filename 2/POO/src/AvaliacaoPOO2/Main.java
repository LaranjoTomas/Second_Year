package AvaliacaoPOO2;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] Args) {

        BookManager bookManager = new BookManager();

        bookManager.load("./AvaliacaoPOO2/books.txt");

        int input;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("1 - Add Book");
            System.out.println("2 - Remove Book");
            System.out.println("3 - Search Book by name");
            System.out.println("4 - Search Book by author");
            System.out.println("5 - Search Book by date interval");
            System.out.println("6 - Seach Book by ISBN");
            System.out.println("7 - List all books");
            System.out.println("8 - List books by name");
            System.out.println("9 - List books by author");
            System.out.println("10 - List books by date from launch");
            System.out.println("0 - Exit");
            System.out.print("Enter option: ");

            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println("What is the name of the book?");
                    String name = sc.next();
                    System.out.println("What is the publisher of the book?");
                    String publisher = sc.next();
                    System.out.println("Who is the author of the book?");
                    String author = sc.next();
                    System.out.println("What is the ISBN of the book?");
                    String isbn = sc.next();
                    System.out.println("What is the release date of the book, in the form of (yyyy/mm/dd)");
                    String releaseDate = sc.next();

                    LocalDate Date = LocalDate.parse(releaseDate);
                    System.out.println(Date);

                    Book newBook = new Book(name, publisher, author, isbn, Date);

                    if (bookManager.addBook(newBook)) {
                        System.out.println("Book added successfully");
                    } else {
                        System.out.println("Error adding book");
                    }
                    break;
                case 2:
                    System.out.println("What is the name of the book?");
                    String nameToRemove = sc.next();
                    System.out.println("What is the publisher of the book?");
                    String publisherToRemove = sc.next();
                    System.out.println("Who is the author of the book?");
                    String authorToRemove = sc.next();
                    System.out.println("What is the ISBN of the book?");
                    String isbnToRemove = sc.next();
                    System.out.println("What is the release date of the book, in the form of (yyyy-mm-dd)");
                    String releaseDateToRemove = sc.next();

                    LocalDate DateToRemove = LocalDate.parse(releaseDateToRemove);
                    System.out.println(DateToRemove);
                    Book bookToRemove = new Book(nameToRemove, publisherToRemove, authorToRemove, isbnToRemove,
                            DateToRemove);

                    if (bookManager.removeBook(bookToRemove)) {
                        System.out.println("Book removed successfully");
                    } else {
                        System.out.println("Error removing book");
                    }
                    break;
                case 3:
                    System.out.println("What is the name of the book?");
                    String nameToSearch = sc.nextLine();
                    Book bookToSearch = bookManager.searchByname(nameToSearch);
                    if (bookToSearch != null) {
                        System.out.println("Book found: " + bookToSearch.toString());
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 4:
                    System.out.println("What is the author of the book?");
                    String authorToSearch = sc.nextLine();
                    List<Book> bookToSearchByAuthor = bookManager.searchByAuthor(authorToSearch);
                    if (bookToSearchByAuthor != null) {
                        System.out.println("Book found: " + bookToSearchByAuthor.toString());
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 5:
                    System.out.println("What is the initial date of the book?");
                    LocalDate fromDate = LocalDate.parse(sc.nextLine());
                    System.out.println("What is the final date of the book?");
                    LocalDate toDate = LocalDate.parse(sc.nextLine());
                    List<Book> bookToSearchByDate = bookManager.searchByDateInterval(fromDate, toDate);
                    if (bookToSearchByDate != null) {
                        System.out.println("Book found: " + bookToSearchByDate.toString());
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 6:
                    System.out.println("What is the ISBN of the book?");
                    String isbnToSearch = sc.nextLine();
                    Book bookToSearchByISBN = bookManager.searchByISBN(isbnToSearch);
                    if (bookToSearchByISBN != null) {
                        System.out.println("Book found: " + bookToSearchByISBN.toString());
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 7:
                    bookManager.listAllBooks();
                    break;
                case 8:
                    bookManager.listBooksByName();
                    break;
                case 9:
                    bookManager.listBooksByAuthor();
                    break;
                case 0:
                    bookManager.save("./AvaliacaoPOO2/books.txt");
                    System.out.println("Exiting...");
                    break;
            }
        } while (input != 0);
        sc.close();
    }
}
