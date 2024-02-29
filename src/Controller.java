import java.util.ArrayList;

public class Controller {
    MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    public String addMovie(String title, String director, String genre, int yearCreated, int lengthInMinutes, boolean isInColor) {
        return movieCollection.addMovie(title, director, genre, yearCreated, lengthInMinutes, isInColor);

    }

    public int getList() {
        return movieCollection.getList();
    }

    public int searchMovie(String title) {
        return movieCollection.searchMovie(title);
    }

    public String removeMovie(String title) {
        return movieCollection.removeMovie(title);
    }

    public String editMovie(String title, ArrayList<String> editValues) throws Exception {
        return movieCollection.editMovie(title, editValues);
    }





}
