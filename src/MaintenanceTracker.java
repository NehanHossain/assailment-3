/* ***************************************
course: COSC1200
Name: Nehan Hossain
Mar 7,2024
produce: Car
 */

// imports
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Maintenance tracker
class MaintenanceTracker {
    public static void addMaintenance(Scanner scanner, ArrayList<Maintenance> maintenanceList, ArrayList<Car> carList, ArrayList<Service> serviceList) {
        System.out.println("Enter Maintenance Details:");
        System.out.print("Enter VIN: ");
        String vinInput = scanner.nextLine();
        Car car = Car.findCarByVIN(Integer.parseInt(vinInput), carList);
        if (car == null) {
            System.out.println("Car not found!");
            return;
        }
        System.out.print("Enter Service Code: ");
        String serviceCode = scanner.nextLine();
        Service service = Service.findService(serviceCode, serviceList);
        if (service == null) {
            System.out.println("Service not found!");
            return;
        }
        System.out.print("Enter Price (Hit Enter to use default price): ");
        String priceInput = scanner.nextLine();
        double price;
        if (!priceInput.isEmpty() && isValidDouble(priceInput)) {
            price = Double.parseDouble(priceInput);
        } else {
            System.out.println("Invalid price format or empty input. Using default price.");
            price = service.getBasePrice();
        }

        LocalDate date = LocalDate.now();
        System.out.print("Enter Date (YYYY-MM-DD, Hit Enter to use today's date): ");
        String dateInput = scanner.nextLine();
        if (!dateInput.isEmpty() && isValidDate(dateInput)) {
            date = LocalDate.parse(dateInput);
        } else {
            System.out.println("Invalid date format or empty input. Using today's date.");
        }

        System.out.print("Enter Notes: ");
        String notes = scanner.nextLine();

        Maintenance maintenance = new Maintenance(car, service, price, date, notes);
        // Add the maintenance to the provided maintenanceList
        maintenanceList.add(maintenance);

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

    public static void showAllMaintenance(ArrayList<Maintenance> maintenanceList) {
        for (Maintenance maintenance : maintenanceList) {
            System.out.println(maintenance);
        }
    }

    public static void deleteMaintenance(Scanner scanner) {
        System.out.println("Maintenance List:");
        showAllMaintenance(Main.maintenanceList);
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

    private static boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidDate(String input) {
        try {
            LocalDate.parse(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
