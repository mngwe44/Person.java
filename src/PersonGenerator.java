import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        boolean continueAdding = true;
        while (continueAdding) {
            System.out.println("Enter person details:");

            System.out.print("Enter ID (String, must not change): ");
            String id = SafeInput.getNonZeroLenString(scanner, "Person ID");

            System.out.print("Enter first name: ");
            String firstName = SafeInput.getNonZeroLenString(scanner, "First Name");

            System.out.print("Enter last name: ");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Last Name");

            System.out.print("Enter title (e.g., Mr, Mrs, Dr): ");
            String title = SafeInput.getNonZeroLenString(scanner, "Title");

            System.out.print("Enter year of birth (e.g., 1985): ");
            int yob = SafeInput.getInt(scanner, "Year of Birth");

            Person person = new Person(id, firstName, lastName, title, yob);
            people.add(person);

            System.out.print("Would you like to add another person? (y/n): ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            if (userInput.equals("no")) {
                continueAdding = false;
            }
        }

        try {
            FileWriter writer = new FileWriter("people.csv");
            for (Person person : people) {
                writer.write(person.toCSV() + "\n");
            }
            writer.close();
            System.out.println("People have been saved to people.csv");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}