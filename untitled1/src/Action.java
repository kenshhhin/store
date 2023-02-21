import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Action {
    static void showAction(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. GoPro");
            System.out.println("2. SJCAM");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> GoPro.showGoPro(connection, scanner);
                case 2 -> SJCAM.showSJCAM(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
