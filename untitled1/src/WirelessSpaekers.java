import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class WirelessSpaekers {
    static void showWirelessSpeakers(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Bluetooth");
            System.out.println("2. Smart");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Bluetooth.showBluetooth(connection, scanner);
                case 2 -> Smart.showSmart(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }
}
