package Aula12.Exer3;

import java.util.*;
import java.io.*;

//Construa um programa que leia o ficheiro para uma estrutura em memória (conjunto de
//Movie) ordenado pelo nome do filme. Liste este estrutura.

public class Exer3 {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            movies = getMoviesList("./Aula12/Exer3/movies.txt");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Movies:");
        System.out.println(movies);

        movies.sort(Comparator.comparing(Movie::getScore).reversed());
        System.out.println("\nMovies sorted by score (descending):");
        System.out.println(movies);

        movies.sort(Comparator.comparing(Movie::getDuration));
        System.out.println("\nMovies sorted by Duration (ascending):");
        System.out.println(movies);

        Set<String> genres = new HashSet<>();
        for (Movie movie : movies) {
            genres.add(movie.getGenre());
        }
        System.out.println("\nGenres:");
        System.out.println(genres);

        // Escreva no ficheiro “myselection.txt” os filmes com um score superior a 60 e
        // que pertençam
        // a um género indicado pelo utilizador

        Scanner sc = new Scanner(System.in);
        System.out.println("\nInsert genre:");
        String genre = sc.nextLine();
        sc.close();

        ArrayList<Movie> mySelection = new ArrayList<>();

        for (Movie movie : movies) {
            if (movie.getScore() > 60 && movie.getGenre().equals(genre)) {
                mySelection.add(movie);
            }
        }
        String outputPath = "./Aula12/Exer3/myselection.txt";
        try {
            writeWordCountsByInitialToFile(mySelection, outputPath);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static ArrayList<Movie> getMoviesList(String path) throws IOException {
        ArrayList<Movie> movies = new ArrayList<>();

        Scanner sc = new Scanner(new FileInputStream(path));
        sc.nextLine();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\t");
            movies.add(new Movie(line[0], Double.parseDouble(line[1]), line[2], line[3], Integer.parseInt(line[4])));
        }
        movies.sort(Comparator.comparing(Movie::getTitle));
        return movies;
    }

    public static void writeWordCountsByInitialToFile(ArrayList<Movie> mySelection, String outputFilePath)
            throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            writer.write("Movies with score 60 or higher of the gender chosen are:\n");
            for (Movie movie : mySelection) {
                writer.write(movie + "\n");
            }
        }
    }
}
