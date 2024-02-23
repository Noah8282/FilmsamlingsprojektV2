import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",");
        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }


    }

}
