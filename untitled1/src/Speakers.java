import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Speakers {
    static void showSpeakers(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Wired");
            System.out.println("2. Wireless");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> WiredSpeakers.showWiredSpeakers(connection, scanner);
                case 2 -> WirelessSpaekers.showWirelessSpeakers(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
