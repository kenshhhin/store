import java.sql.*;
import java.util.Scanner;

public class Smart {
    static void showSmart(Connection connection, Scanner scanner) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM goods where id >= 41 and id <= 44");
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
