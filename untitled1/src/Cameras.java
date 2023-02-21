import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Cameras {
    static void showCameras(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Photo cameras");
            System.out.println("2. Video cameras");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Photo.showPhoto(connection, scanner);
                case 2 -> Video.showVideo(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
