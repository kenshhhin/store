import java.sql.*;
import java.util.Scanner;

public class Consoles {
    static void showConsoles(Connection connection, Scanner scanner) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM goods where id >= 51 and id <= 61");
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
