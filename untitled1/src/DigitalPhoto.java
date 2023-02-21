import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DigitalPhoto {
    static void showDigitalPhoto(Connection connection, Scanner scanner) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM goods where id >= 144 and id <= 149");

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
