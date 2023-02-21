import java.sql.*;
import java.util.Scanner;

public class WirelessHeadphones {
    static void showWirelessHeadphones(Connection connection, Scanner scanner) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM goods where id >= 16 and id <= 32");
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