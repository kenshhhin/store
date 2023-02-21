import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Entertaiment {
    static void showEntertaiment(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Consoles");
            System.out.println("2. Games");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Consoles.showConsoles(connection, scanner);
                case 2 -> Games.showGames(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
