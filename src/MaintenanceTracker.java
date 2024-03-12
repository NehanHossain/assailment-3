/* ***************************************
course: COSC1200
Name: Nehan Hossain
Mar 7,2024
produce: Car
 */

import java.time.LocalDate;
import java.util.Scanner;

public class MaintenanceTracker {

    public static void addMaintenance(Scanner scanner) {
        System.out.println("Enter Maintenance Details:");

        System.out.print("Enter VIN: ");
        String vin = scanner.nextLine();
        Car car = Car.findCarByVIN(Integer.parseInt(vin), Main.carList);
        if (car == null) {
            System.out.println("Car not found!");
            return;
        }

        System.out.print("Enter Service Code: ");
        String serviceCode = scanner.nextLine();
        Service service = Service.findService(serviceCode, Main.serviceList);
        if (service == null) {
            System.out.println("Service not found!");
            return;
        }

        System.out.print("Enter Price (Hit Enter to use default price): ");
        String priceInput = scanner.nextLine();
        double price;
        if (priceInput.isEmpty()) {
            price = service.getBasePrice();
        } else {
            price = Double.parseDouble(priceInput);
        }

        LocalDate date = LocalDate.now();
        System.out.print("Enter Date (YYYY-MM-DD, Hit Enter to use today's date): ");
        String dateInput = scanner.nextLine();
        if (!dateInput.isEmpty()) {
            date = LocalDate.parse(dateInput);
        }

        System.out.print("Enter Notes: ");
        String notes = scanner.nextLine();

        Maintenance maintenance = new Maintenance(car, service, price, date, notes);
        Main.maintenanceList.add(maintenance);

        System.out.println("Maintenance added successfully:");
        System.out.println(maintenance);
    }

    public static void showMaintenanceByInvoice(Scanner scanner) {
        System.out.print("Enter Invoice ID: ");
        int invoiceId = scanner.nextInt();
        Maintenance maintenance = Maintenance.findMaintenanceByInvoice(invoiceId, Main.maintenanceList);
        if (maintenance == null) {
            System.out.println("Maintenance not found!");
            return;
        }
        System.out.println(maintenance);
    }

    public static void showAllMaintenance() {
        for (Maintenance maintenance : Main.maintenanceList) {
            System.out.println(maintenance);
        }
    }

    public static void deleteMaintenance(Scanner scanner) {
        System.out.println("Maintenance List:");
        showAllMaintenance();
        System.out.print("Enter Invoice ID to delete: ");
        int invoiceId = scanner.nextInt();
        Maintenance maintenance = Maintenance.findMaintenanceByInvoice(invoiceId, Main.maintenanceList);
        if (maintenance == null) {
            System.out.println("Maintenance not found!");
            return;
        }
        Main.maintenanceList.remove(maintenance);
        System.out.println("Maintenance deleted successfully.");
    }
}
