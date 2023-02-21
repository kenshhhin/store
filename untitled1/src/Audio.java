import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Audio {
    static void showAudio(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Headphones");
            System.out.println("2. Speakers");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Headphones.showHeadphones(connection, scanner);
                case 2 -> Speakers.showSpeakers(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
