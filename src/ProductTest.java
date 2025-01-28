import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    // Setup a sample product object for testing
    @BeforeEach
    public void setUp() {
        product = new Product("Laptop", "High-end gaming laptop", "P12345", 1500.99);
    }

    // Test the getters
    @Test
    public void testGetName() {
        assertEquals("Laptop", product.getName(), "Product name should be 'Laptop'");
    }

    @Test
    public void testGetDescription() {
        assertEquals("High-end gaming laptop", product.getDescription(), "Product description should match.");
    }

    @Test
    public void testGetID() {
        assertEquals("P12345", product.getID(), "Product ID should match.");
    }

    @Test
    public void testGetCost() {
        assertEquals(1500.99, product.getCost(), 0.01, "Product cost should match.");
    }

    // Test the setters
    @Test
    public void testSetName() {
        product.setName("Smartphone");
        assertEquals("Smartphone", product.getName(), "Product name should be updated.");
    }

    @Test
    public void testSetDescription() {
        product.setDescription("Flagship smartphone with advanced features.");
        assertEquals("Flagship smartphone with advanced features.", product.getDescription(), "Product description should be updated.");
    }

    @Test
    public void testSetCost() {
        product.setCost(1200.50);
        assertEquals(1200.50, product.getCost(), 0.01, "Product cost should be updated.");
    }

    @Test
    public void testSetInvalidCost() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            product.setCost(-100.00);
        });
        assertEquals("Cost cannot be negative.", exception.getMessage(), "Setting a negative cost should throw an exception.");
    }

    // Test conversion to CSV
    @Test
    public void testToCSV() {
        String expectedCSV = "Laptop,High-end gaming laptop,P12345,1500.99";
        assertEquals(expectedCSV, product.toCSV(), "CSV representation should match the expected format.");
    }

    // Test conversion to JSON
    @Test
    public void testToJSON() {
        String expectedJSON = "{\n" +
                "  \"name\": \"Laptop\",\n" +
                "  \"description\": \"High-end gaming laptop\",\n" +
                "  \"ID\": \"P12345\",\n" +
                "  \"cost\": 1500.99\n" +
                "}";
        assertEquals(expectedJSON, product.toJSON(), "JSON representation should match the expected format.");
    }

    // Test conversion to XML
    @Test
    public void testToXML() {
        String expectedXML = "<Product>\n" +
                "  <Name>Laptop</Name>\n" +
                "  <Description>High-end gaming laptop</Description>\n" +
                "  <ID>P12345</ID>\n" +
                "  <Cost>1500.99</Cost>\n" +
                "</Product>";
        assertEquals(expectedXML, product.toXML(), "XML representation should match the expected format.");
    }
}