import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public void startUI() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        Controller controller = new Controller();
        String SENTINAL = "exit";
        String input;
        String title;
        do {
            System.out.println("Welcome to the movie collection!: Type following commands:\n" +
                    "Add: Add movie\n" +
                    "List: See a list of movies in your collection\n" +
                    "Search: Search for a movie\n" +
                    "Remove: Remove movie\n" +
                    "Edit: Edit a movie\n" +
                    "Exit: Exit the program");
            input = scanner.next().toLowerCase();

            if (input.equals("add")) {
                System.out.println("What is the title of the movie?");
                title = scanner.next();
                System.out.println("Who is the director of the movie?");
                String director = scanner.next();
                System.out.println("What is the genre of the movie?");
                String genre = scanner.next();
                System.out.println("What year was the movie created?");
                int yearCreated = scanner.nextInt();
                System.out.println("What is the length of the movie in minutes?");
                int lengthInMinutes = scanner.nextInt();

                System.out.println("Is the movie in color or black/white. Type Yes if in color. Type no if Black/White");
                scanner.next();
                boolean isInColor = (!scanner.nextLine().equalsIgnoreCase("no"));

                System.out.println(controller.addMovie(title, director, genre, yearCreated, lengthInMinutes, isInColor));
            } else
            if (input.equals("list")) {
                controller.getList();
            } else
            if (input.equals("search")) {
                System.out.println("What is the title of the movie you'd wish to search for?");
                title = scanner.next();
                controller.searchMovie(title);
            } else
            if (input.equals("remove")) {
                System.out.println("What is the title of the movie you'd wish to remove?");
                title = scanner.next();
                System.out.println(controller.removeMovie(title));
            } else
            if (input.equals("edit")) {
                System.out.println("Please type the title of the movie you'd like to edit");
                title = scanner.next();
                int searhResult = controller.searchMovie(title);
                if (searhResult != 1) {
                    System.out.println("The system found 0 mathes or more than 1. See list if more than 1, and specify the exact title.");
                } else {
                    ArrayList<String> editValues = new ArrayList<>();
                    System.out.println("Please input new values, seperating new by comma. Write as: Title, Director, Genre, yearCreated, Length In Minutes, If in color. Type yes if colored. If in Black/White type no.");
                    Scanner editScanner = new Scanner(scanner.next());
                    editScanner.useDelimiter(",");
                    while (editScanner.hasNext()) {
                        editValues.add(editScanner.next());
                    }
                    System.out.println(controller.editMovie(title, editValues));
                    editScanner.close();
                }
            } else {
                System.out.println("Not correct input inserted.");
            }
            System.out.println();
        } while (!input.equals("exit"));


    }


}
