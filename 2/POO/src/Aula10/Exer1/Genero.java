package Aula10.Exer1;

import java.util.HashMap;
import java.util.Map;

public class Genero extends Book {

    private String genero;
    private Map<String, Book> generos;

    public Genero(String genero, String title, String author, int year) {
        super(title, author, year);
        this.genero = genero;
        this.generos = new HashMap<>();
    }

    public String getGenero() {
        return genero;
    }

    public Map<String, Book> getGeneros() {
        return generos;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setGeneros(Map<String, Book> generos) {
        this.generos = generos;
    }

    public void addBook(Book book) {
        generos.put(genero, book);
    }

    public void removeBook(Book book) {
        generos.remove(genero, book);
    }

    public void changeBook(Book book) {
        generos.replace(genero, book);
    }

    @Override
    public String toString() {
        return "Genero: " + genero + "\n" + super.toString();
    }

}
