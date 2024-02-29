import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    void addMovie() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();

        //Act
        movieCollection.addMovie("Unicorn 1", "Noah", "Action", 2024, 120, true);
        int expectedResult = 1;
        int actualResult = movieCollection.getList();

        //Assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void removeMovie() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Unicorn 1", "Noah", "Action", 2024, 120, true);

        //Act test String
        String expectedResultString = "Unicorn 1 has been removed!";
        String actualResultString = movieCollection.removeMovie("Unicorn 1");

        //Assert
        assertEquals(expectedResultString,actualResultString);

        movieCollection.addMovie("Unicorn 1", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("Unicorn 2", "Noah", "Action", 2024, 120, true);

        //Act Test Length Of List
        movieCollection.removeMovie("Unicorn 1");
        int expectedResultInt = 1;
        int actualResultInt = movieCollection.getList();

        //Assert
        assertEquals(expectedResultInt,actualResultInt);

         /*System.out.println("Hello!");

        assertEquals("Hello!",outContent.toString().trim());*/

    }



    @Test
    void getList() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Unicorn 1", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("Unicorn 2", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("Unicorn 3", "Noah", "Action", 2024, 120, true);

        //Act
        int expectedResult = 3;
        int actualResult = movieCollection.getList();

        //Assert
        assertEquals(expectedResult,actualResult);


    }

    @Test
    void searchExactResult() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Unicorn 1", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("Bad guy", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("Serious", "Noah", "Action", 2024, 120, true);

        //Act
        int expectedResult = 1;
        int actualValue = movieCollection.searchMovie("Unicorn 1");

        assertEquals(expectedResult,actualValue);

    }

    @Test
    void searchCloseResult() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Unicorn 1", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("Universal Studio Guy", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("The Uni-parol woman", "Noah", "Action", 2024, 120, true);

        //Act
        int expectedResult = 3;
        int actualValue = movieCollection.searchMovie("uni");

        //Assert
        assertEquals(expectedResult,actualValue);

    }
    @Test
    void searchNoResult() {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Unicorn 1", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("Universal Studio Guy", "Noah", "Action", 2024, 120, true);
        movieCollection.addMovie("The Uni-parol woman", "Noah", "Action", 2024, 120, true);

        //Act
        int expectedResult = 0;
        int actualValue = movieCollection.searchMovie("No Movie With This Title");

        //Assert
        assertEquals(expectedResult,actualValue);

    }

    @Test
    void editMovieSuccess() throws Exception {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Hard type", "Peter", "Drama", 2023, 100, false);

        //Act
        String actualValue = movieCollection.editMovie("Hard type",new ArrayList<String>(Arrays.asList("Unicorn 1", "Noah", "Action", "2024", "120", "yes")));
        String expectedResult = "Movie Hard type has been edited!\n"+
                "Title: Unicorn 1\n" +
                "Director: Noah\n" +
                "Genre: Action\n" +
                "Year: 2024\n" +
                "Length: 120 min\n" +
                "Color: Colored\n";

        //Assert
        assertEquals(expectedResult,actualValue);


    }

    @Test
    void editMovieInvalid() throws Exception {
        //Arrange
        MovieCollection movieCollection = new MovieCollection();
        movieCollection.addMovie("Hard type", "Peter", "Drama", 2023, 100, false);

        //Act
        String actualValue = movieCollection.editMovie("Hard type",new ArrayList<String>(Arrays.asList("Unicorn 1", "Noah", "Action", "2024", "120")));
        String expectedResult = "All values have not been inserted. Please try again";

        //Assert
        assertEquals(expectedResult,actualValue);


    }


}