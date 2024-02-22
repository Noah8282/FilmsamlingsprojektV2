import java.util.ArrayList;


public class MovieCollection {

    private ArrayList<Movie> movieCollection;


    public MovieCollection() {
        movieCollection = new ArrayList<>();
        movieCollection.add(new Movie("Unicorn 1", "Noah", "Action", 2024, 120, true));
        movieCollection.add(new Movie("Unicorn 2", "Noah", "Action", 2024, 120, true));
    }

    public String addMovie(String title, String director, String genre, int yearCreated, int lengthInMinutes, boolean isInColor) {
        movieCollection.add(new Movie(title,director,genre,yearCreated,lengthInMinutes,isInColor));
        return title + " was added to the collection!";
    }

    public String removeMovie(String title) {
        for (int i = 0; i <= movieCollection.size(); i++) {
            Movie m = movieCollection.get(i);
            if(m.getTitle().equalsIgnoreCase(title)) {
                String removedTitle = movieCollection.get(i).getTitle();
                movieCollection.remove(i);
                return removedTitle + " has been removed!";
            }
        }

        return "No movie was found to delete";
    }

    public void getList() {
        System.out.println("List of movies");
        for (Movie m : movieCollection) {
            System.out.println(m.toString());
        }


    }

    public void searchMovie(String title) {
        ArrayList<Movie> matchingElements = new ArrayList<>();

        for (Movie m : movieCollection) {
            if(m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchingElements.add(m);
            }
        }

        if(matchingElements.isEmpty()) {
            System.out.println("No matches found in the movie collection");
        } else {
            System.out.println("I found the following movie(s):\n");
            for (Movie m : matchingElements) {
                System.out.println(m.toString());
            }
        }

    }






}