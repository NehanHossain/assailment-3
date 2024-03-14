/* ***************************************
course: COSC1200
Name: Nehan Hossain
Mar 7,2024
produce: Car
*/

// imports
import java.time.LocalDate;
import java.util.List;

//Maintenance
public class Maintenance {
    // Fields
    private Car car;
    private Service service;
    private double price;
    private LocalDate date;
    private String notes;
    private int invoiceId;

    // Constructor
    public Maintenance(Car car, Service service, double price, LocalDate date, String notes, int invoiceId) {
        this.car = car;
        this.service = service;
        this.price = price;
        this.date = date;
        this.notes = notes;
        this.invoiceId = invoiceId;
    }

    // Method to find maintenance entry by invoice ID
    public static Maintenance findMaintenanceByInvoice(int invoiceId, List<Maintenance> maintenanceList) {
        for (Maintenance maintenance : maintenanceList) {
            if (maintenance.getInvoiceId() == invoiceId) {
                return maintenance;
            }
        }
        return null;
    }

    // Getter method for invoice ID
    public int getInvoiceId() {
        return invoiceId;
    }

    // Method to convert maintenance details to string representation
    public String toString() {
        return "Invoice ID: " + invoiceId + "\n" +
                "Car: " + car + "\n" +
                "Service: " + service + "\n" +
                "Price: " + price + "\n" +
                "Date: " + date + "\n" +
                "Notes: " + notes;
    }

    // Method to convert maintenance details to a formatted table
    public static String toTable(List<Maintenance> maintenanceList) {
        StringBuilder table = new StringBuilder();
        table.append("Invoice ID | Car | Service | Price | Date | Notes\n");
        for (Maintenance maintenance : maintenanceList) {
            table.append(String.format("%-10d | %-20s | %-20s | %-10.2f | %s | %s\n",
                    maintenance.getInvoiceId(), maintenance.getCar(), maintenance.getService(),
                    maintenance.getPrice(), maintenance.getDate(), maintenance.getNotes()));
        }
        return table.toString();
    }

    // getters
    public Car getCar() {
        return car;
    }

    public Service getService() {
        return service;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}