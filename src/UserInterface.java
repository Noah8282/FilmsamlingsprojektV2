import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Controller controller;
    String title;
    String input;

    public UserInterface() {
        controller = new Controller();
        title = "";
        input = "";
    }
    public void startUI() {
        do {
            menu();
            input = getUserInput();
            switch (input) {
                case "add" -> add();
                case "list" -> controller.getList();
                case "search" -> search();
                case "remove" -> remove();
                case "edit" -> edit();
                default -> {
                    if (!input.equals("exit")) {
                        System.out.println("Not correct input inserted.");
                    }
                }
            }
            System.out.println();
        } while (!input.equals("exit"));
    }

    public String getUserInput() {
        return getUserInput(true);
    }

    public String getUserInput(boolean toLower) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        input = scanner.next();
        if (toLower) {
            return input.toLowerCase();
        }
        return input;
    }

    public int getUserInput(int toInt) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        return scanner.nextInt();
    }

    public void menu() {
        System.out.println("Welcome to the movie collection!: Type following commands:\n" +
                "Add: Add movie\n" +
                "List: See a list of movies in your collection\n" +
                "Search: Search for a movie\n" +
                "Remove: Remove movie\n" +
                "Edit: Edit a movie\n" +
                "Exit: Exit the program");
    }

    public void add() {
        String title;
        System.out.println("What is the title of the movie?");
        title = getUserInput(false);
        System.out.println("Who is the director of the movie?");
        String director = getUserInput(false);
        System.out.println("What is the genre of the movie?");
        String genre = getUserInput(false);
        System.out.println("What year was the movie created?");
        int yearCreated = getUserInput(0);
        System.out.println("What is the length of the movie in minutes?");
        int lengthInMinutes = getUserInput(0);

        System.out.println("Is the movie in color or black/white. Type Yes if in color. Type no if Black/White");
        boolean isInColor = (!getUserInput().equals("no"));

        System.out.println(controller.addMovie(title, director, genre, yearCreated, lengthInMinutes, isInColor));
    }

    public void search() {
        System.out.println("What is the title of the movie you'd wish to search for?");
        title = getUserInput();
        controller.searchMovie(title);
    }

    public void remove() {
        System.out.println("What is the title of the movie you'd wish to remove?");
        title = getUserInput();
        System.out.println(controller.removeMovie(title));
    }

    public void edit() {
        System.out.println("Please type the title of the movie you'd like to edit");
        title = getUserInput();
        int searhResult = controller.searchMovie(title);
        if (searhResult != 1) {
            System.out.println("The system found 0 mathes or more than 1. See list if more than 1, and specify the exact title.");
        } else {
            ArrayList<String> editValues = new ArrayList<>();
            System.out.println("Please input new values, seperating new by comma. Write as: Title, Director, Genre, yearCreated, Length In Minutes, If in color. Type yes if colored. If in Black/White type no.");
            Scanner editScanner = new Scanner(getUserInput(false));
            editScanner.useDelimiter(",");
            while (editScanner.hasNext()) {
                editValues.add(editScanner.next());
            }
            System.out.println(controller.editMovie(title, editValues));
            editScanner.close();
        }
    }

}
