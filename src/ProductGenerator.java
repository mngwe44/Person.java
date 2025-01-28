import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        boolean continueAdding = true;
        while (continueAdding) {
            // Collect product data from user
            System.out.println("Enter product details:");

            System.out.print("Enter product ID (String, must not change): ");
            String id = SafeInput.getNonZeroLenString(scanner, "Product ID");

            System.out.print("Enter product name: ");
            String name = SafeInput.getNonZeroLenString(scanner, "Product Name");

            System.out.print("Enter product description: ");
            String description = SafeInput.getNonZeroLenString(scanner, "Product Description");

            System.out.print("Enter product cost (double): ");
            double cost = SafeInput.getDouble(scanner, "Product Cost");

            // Create Product object and add to list
            Product product = new Product(id, name, description, cost);
            products.add(product);

            // Ask if user wants to continue adding products
            System.out.print("Would you like to add another product? (yes/no): ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (userInput.equals("no")) {
                continueAdding = false;
            }
        }

        // Write products to CSV file
        try {
            FileWriter writer = new FileWriter("products.csv");
            for (Product product : products) {
                writer.write(product.toCSV() + "\n");
            }
            writer.close();
            System.out.println("Products have been saved to products.csv");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}