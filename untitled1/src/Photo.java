import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Photo {
    static void showPhoto(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Full-frame");
            System.out.println("2. Digital");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> FullFrame.showFullFrame(connection, scanner);
                case 2 -> DigitalPhoto.showDigitalPhoto(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
