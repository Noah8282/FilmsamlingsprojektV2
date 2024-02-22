public class Controller {
    MovieCollection movieCollection;

    public Controller() {
        movieCollection = new MovieCollection();
    }

    public String addMovie(String title, String director, String genre, int yearCreated, int lengthInMinutes, boolean isInColor) {
        return movieCollection.addMovie(title, director, genre, yearCreated, lengthInMinutes, isInColor);

    }

    public void getList() {
        movieCollection.getList();
    }

    public void searchMovie(String title) {
        movieCollection.search(title);
    }

    public String removeMovie(String title) {
        return movieCollection.removeMovie(title);
    }

    /*public String editMovie(String searchElement, String searchString) {
        return movieCollection.editMovie(searchElement,searchString);
    }*/





}
