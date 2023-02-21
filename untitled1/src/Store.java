import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private static final ArrayList<Goods> cart = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        System.out.println(" ");
        System.out.println("Welcome to Multimedia store !");
        while (true) {

            System.out.println(" ");
            System.out.println("1. Show all goods");
            System.out.println("2. Show cart");
            System.out.println("3. Quit");
            System.out.println(" ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showAllGoods(connection, scanner);
                case 2 -> showCart(scanner);
                case 3 -> {
                    System.out.println("Exiting ...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void showAllGoods(Connection connection, Scanner scanner) throws SQLException {
        while (true) {
            System.out.println(" ");
            System.out.println("1. Audio");
            System.out.println("2. Entertainment");
            System.out.println("3. Cameras");
            System.out.println("0. Back");
            System.out.println(" ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Audio.showAudio(connection, scanner);
                case 2 -> Entertaiment.showEntertaiment(connection, scanner);
                case 3 -> Cameras.showCameras(connection, scanner);
                case 0 -> {
                    System.out.println("Going back...");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    static void addToCart(Scanner scanner, Connection connection) throws SQLException {
        System.out.println("Enter the ID of the item you want to add(if you didn't select anything enter 0):");
        int itemId = scanner.nextInt();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM goods WHERE id = ?");
        statement.setInt(1, itemId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            Goods good = new Goods(id, name, price);
            cart.add(good);
            System.out.println("Item added to cart: " + good);
        } else {
            System.out.println("Item not found");
        }
    }

    private static void showCart(Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (Goods good : cart) {
                System.out.println(good.toString());
            }
            int totalPrice = 0;
            for (Goods good : cart) {
                totalPrice += good.getPrice();
            }
            System.out.println(" ");
            System.out.println("Total price: " + totalPrice + " тг");
            System.out.println(" ");
            System.out.println("Enter the ID of the item you want to remove(if you didn't select anything enter 0):");
            int itemId = scanner.nextInt();

            for (int i = 0; i < cart.size(); i++) {
                Goods good = cart.get(i);
                if (good.getId() == itemId) {
                    cart.remove(i);
                    System.out.println("Item removed from cart: " + good);
                    return;
                } else if (itemId == 0) {
                    break;
                } else {
                    System.out.println("Item not found in cart");
                }
            }
        }
    }
}
