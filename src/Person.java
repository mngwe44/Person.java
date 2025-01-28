import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        } else {
            throw new IllegalArgumentException("Year of Birth must be between 1940 and 2010");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    public String toJSON() {
        return "{\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"YOB\": " + YOB + "\n" +
                "}";
    }

    public String toXML() {
        return "<Person>\n" +
                "  <FirstName>" + firstName + "</FirstName>\n" +
                "  <LastName>" + lastName + "</LastName>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <Title>" + title + "</Title>\n" +
                "  <YOB>" + YOB + "</YOB>\n" +
                "</Person>";
    }

    public static void main(String[] args) {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1985);

        System.out.println("Full Name: " + person.fullName());
        System.out.println("Formal Name: " + person.formalName());
        System.out.println("Current Age: " + person.getAge());
        System.out.println("Age in 2050: " + person.getAge(2050));
        System.out.println("CSV Representation:\n" + person.toCSV());
        System.out.println("JSON Representation:\n" + person.toJSON());
        System.out.println("XML Representation:\n" + person.toXML());
    }

    public void setFirstName(String jane) {
    }

    public void setTitle(String s) {
    }

    public void setLastName(String smith) {
    }

    public void setYOB(int i) {
    }
}