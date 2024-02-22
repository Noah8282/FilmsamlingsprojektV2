import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            input = scanner.nextLine().toLowerCase();

            if(input.equals("add")) {
                System.out.println("What is the title of the movie?");
                title = scanner.nextLine();
                System.out.println("Who is the director of the movie?");
                String director = scanner.nextLine();
                System.out.println("What is the genre of the movie?");
                String genre =  scanner.nextLine();
                System.out.println("What year was the movie created?");
                int yearCreated = scanner.nextInt();
                System.out.println("What is the length of the movie in minutes?");
                int lengthInMinutes = scanner.nextInt();;
                System.out.println("Is the movie in color or black/white. Type Yes if in color. Type no if Black/White");
                scanner.nextLine();
                boolean isInColor = (!scanner.nextLine().equalsIgnoreCase("no"));

                System.out.println(controller.addMovie(title,director,genre,yearCreated,lengthInMinutes,isInColor));
            }
            if(input.equals("list")) {
                controller.getList();
            }
            if(input.equals("search")) {
                System.out.println("What is the title of the movie you'd wish to search for?");
                title = scanner.nextLine();
                controller.searchMovie(title);
            }
            if(input.equals("remove")) {
                System.out.println("What is the title of the movie you'd wish to remove?");
                title = scanner.nextLine();
                System.out.println(controller.removeMovie(title));
            }
            if(input.equals("edit")) {


            }



            System.out.println();
        } while (!input.equals("exit"));


    }



}
