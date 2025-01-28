public class Product {
    private String name;
    private String description;
    private String ID; // should never change
    private double cost;

    // Constructor
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }
    }

    // Convert to CSV
    public String toCSV() {
        return name + "," + description + "," + ID + "," + cost;
    }

    // Convert to JSON
    public String toJSON() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"cost\": " + cost + "\n" +
                "}";
    }

    // Convert to XML
    public String toXML() {
        return "<Product>\n" +
                "  <Name>" + name + "</Name>\n" +
                "  <Description>" + description + "</Description>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <Cost>" + cost + "</Cost>\n" +
                "</Product>";
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a sample Product object
        Product product = new Product("Laptop", "High-end gaming laptop", "P12345", 1500.99);

        // Test the methods
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Description: " + product.getDescription());
        System.out.println("Product ID: " + product.getID());
        System.out.println("Product Cost: $" + product.getCost());

        System.out.println("CSV Representation:\n" + product.toCSV());
        System.out.println("JSON Representation:\n" + product.toJSON());
        System.out.println("XML Representation:\n" + product.toXML());
    }
}