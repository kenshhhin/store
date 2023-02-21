import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class FullFrame {
    static void showFullFrame(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Sony");
            System.out.println("2. Nikon");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Sony.showSony(connection, scanner);
                case 2 -> Nikon.showNikon(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
