package Aula12.Exer3;

public class Movie {

    private String title;
    private Double score;
    private String rating;
    private String genre;
    private int duration;

    public Movie(String title, Double score, String rating, String genre, int duration) {
        this.title = title;
        this.score = score;
        this.rating = rating;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public Double getScore() {
        return score;
    }

    public String getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String setTitle(String title) {
        return this.title = title;
    }

    public Double setScore(Double score) {
        return this.score = score;
    }

    public String setRating(String rating) {
        return this.rating = rating;
    }

    public String setGenre(String genre) {
        return this.genre = genre;
    }

    public int setDuration(int duration) {
        return this.duration = duration;
    }

    @Override
    public String toString() {
        return "Titlo:" + title + ", duration: " + duration + ", genre: " + genre + ", title: " + title
                + ", Genro: " + genre + ".\n";
    }

}
