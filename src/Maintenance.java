/* ***************************************
course: COSC1200
Name: Nehan Hossain
Mar 7,2024
produce: Car
 */

// imports
import java.time.LocalDate;
import java.util.ArrayList;

// Maintenance
class Maintenance {
    private Car car;
    private Service service;
    private double price;
    private LocalDate date;
    private String notes;

    public Maintenance(Car car, Service service, double price, LocalDate date, String notes) {
        this.car = car;
        this.service = service;
        this.price = price;
        this.date = date;
        this.notes = notes;
    }

    public static Maintenance findMaintenanceByInvoice(int invoiceId, ArrayList<Maintenance> maintenanceList) {
        // Implement logic to find maintenance by invoice ID
        return null;
    }
}

