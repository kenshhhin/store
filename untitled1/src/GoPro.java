import java.sql.*;
import java.util.Scanner;

public class GoPro {
    static void showGoPro(Connection connection, Scanner scanner) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM goods where id >= 101 and id <= 109");
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
