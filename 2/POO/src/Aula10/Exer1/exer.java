package Aula10.Exer1;

public class exer {
    public static void main(String[] args) {
        Book b1 = new Book("Harry Potter", "J.K. Rowling", 1997);
        Book b2 = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book b4 = new Book("The Hunger Games", "Suzanne Collins", 2008);
        Book b5 = new Book("The Da Vinci Code", "Dan Brown", 2003);

        Genero g1 = new Genero("Fantasy", b1.getTitle(), b1.getAuthor(), b1.getYear());
        Genero g2 = new Genero("Fantasy", b2.getTitle(), b2.getAuthor(), b2.getYear());
        Genero g3 = new Genero("Fantasy", b3.getTitle(), b3.getAuthor(), b3.getYear());
        Genero g4 = new Genero("Science Fiction", b4.getTitle(), b4.getAuthor(), b4.getYear());
        Genero g5 = new Genero("Mystery", b5.getTitle(), b5.getAuthor(), b5.getYear());

        g1.addBook(b1);
        g2.addBook(b2);
        g3.addBook(b3);
        g4.addBook(b4);
        g5.addBook(b5);

        System.out.println("-----------------------------------------------");

        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        System.out.println(g4.toString());
        System.out.println(g5.toString());

        g1.changeBook(b2);
        g2.changeBook(b3);
        g3.changeBook(b4);
        g4.changeBook(b5);
        g5.changeBook(b1);

        System.out.println("-----------------------------------------------");

        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        System.out.println(g4.toString());
        System.out.println(g5.toString());

        g1.removeBook(b2);
        g2.removeBook(b3);
        g3.removeBook(b4);
        g4.removeBook(b5);
        g5.removeBook(b1);

        System.out.println("-----------------------------------------------");

        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(g3.toString());
        System.out.println(g4.toString());
        System.out.println(g5.toString());

    }
}
