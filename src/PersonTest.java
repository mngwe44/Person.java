import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("John", "Doe", "P12345", "Mr.", 1990);
    }

    @Test
    public void testFullName() {
        assertEquals("John Doe", person.fullName(), "Full name should be 'John Doe'");
    }

    @Test
    public void testFormalName() {
        assertEquals("Mr. John Doe", person.formalName(), "Formal name should be 'Mr. John Doe'");
    }

    @Test
    public void testGetAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int age = currentYear - 1990;
        assertEquals(String.valueOf(age), person.getAge(), "Age should be correctly calculated.");
    }

    @Test
    public void testGetAgeForYear() {
        assertEquals("35", person.getAge(2025), "Age in 2025 should be 35.");
    }

    @Test
    public void testToCSV() {
        String expectedCSV = "John,Doe,P12345,Mr.,1990";
        assertEquals(expectedCSV, person.toCSV(), "CSV representation should match the expected format.");
    }

    @Test
    public void testToJSON() {
        String expectedJSON = "{\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"ID\": \"P12345\",\n" +
                "  \"title\": \"Mr.\",\n" +
                "  \"YOB\": 1990\n" +
                "}";
        assertEquals(expectedJSON, person.toJSON(), "JSON representation should match the expected format.");
    }

    @Test
    public void testToXML() {
        String expectedXML = "<Person>\n" +
                "  <FirstName>John</FirstName>\n" +
                "  <LastName>Doe</LastName>\n" +
                "  <ID>P12345</ID>\n" +
                "  <Title>Mr.</Title>\n" +
                "  <YOB>1990</YOB>\n" +
                "</Person>";
        assertEquals(expectedXML, person.toXML(), "XML representation should match the expected format.");
    }

    @Test
    public void testInvalidYOB() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setYOB(2030); // Invalid future year
        });
        assertEquals("Year of birth must be between 1940 and 2010.", exception.getMessage(), "Invalid year of birth should throw an exception.");
    }

    @Test
    public void testSetFirstName() {
        person.setFirstName("Jane");
        assertEquals("Jane", person.getFirstName(), "First name should be updated.");
    }

    @Test
    public void testSetLastName() {
        person.setLastName("Smith");
        assertEquals("Smith", person.getLastName(), "Last name should be updated.");
    }

    @Test
    public void testSetTitle() {
        person.setTitle("Dr.");
        assertEquals("Dr.", person.getTitle(), "Title should be updated.");
    }

    @Test
    public void testSetYOB() {
        person.setYOB(1985);
        assertEquals(1985, person.getYOB(), "Year of birth should be updated.");
    }
}