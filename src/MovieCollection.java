import java.util.ArrayList;
import java.util.InputMismatchException;


public class MovieCollection {

    private ArrayList<Movie> movieCollection;


    public MovieCollection() {
        movieCollection = new ArrayList<>();
    }

    public String addMovie(String title, String director, String genre, int yearCreated, int lengthInMinutes, boolean isInColor) {
        movieCollection.add(new Movie(title, director, genre, yearCreated, lengthInMinutes, isInColor));
        return title + " was added to the collection!";
    }

    public String removeMovie(String title) {
        for (int i = 0; i <= movieCollection.size(); i++) {
            Movie m = movieCollection.get(i);
            if (m.getTitle().equalsIgnoreCase(title)) {
                String removedTitle = movieCollection.get(i).getTitle();
                movieCollection.remove(i);
                return removedTitle + " has been removed!";
            }
        }

        return "No movie was found to delete";
    }

    public int getList() {
        int count = 0;
        System.out.println("List of movies");
        for (Movie m : movieCollection) {
            System.out.println(m.toString());
            count++;
        }
        return count;
    }

    public int searchMovie(String title) {
        int count = 0;
        System.out.println("Search results can be seen below.");
        for (Movie m : movieCollection) {
            if (m.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(m.toString());
                count++;
            }
        }
        if(count == 0) {
            System.out.println("No matches found in the movie collection");
        }
        return count;

    }

    public String editMovie(String title, ArrayList<String> editValues) throws Exception {
        if(editValues.size() < 6) {
            return "All values have not been inserted. Please try again";
        }
        String message = "";
        for(Movie m : movieCollection) {
            if(m.getTitle().toLowerCase().equalsIgnoreCase(title)) {
                m.setTitle(editValues.get(0).trim());
                m.setDirector(editValues.get(1).trim());
                m.setGenre(editValues.get(2).trim());
                try {
                    m.setYearCreated(Integer.parseInt(editValues.get(3).trim()));
                    m.setLengthInMinutes(Integer.parseInt(editValues.get(4).trim()));
                } catch(NumberFormatException nfe) {
                    System.out.println("You need to insert a number.");
                    throw new Exception("Invalid");
                }

                m.setInColor(!(editValues.get(5).trim()).equalsIgnoreCase("no"));
                message = m.toString();
                break;

            }

        }
        return "Movie " + title + " has been edited!\n" + message;
    }


}