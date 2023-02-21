import java.sql.*;
import java.util.Scanner;

public class Bluetooth {
    static void showBluetooth(Connection connection, Scanner scanner) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM goods where id >= 45 and id <= 50");
        ResultSet resultSet = statement.executeQuery();

        System.out.println("ID | Name | Price");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            System.out.println(id + " | " + name + " | " + price + " тг");
        }
        Store.addToCart(scanner, connection);
    }
}
