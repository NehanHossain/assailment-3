/* ***************************************
course: COSC1200
Name: Nehan Hossain
Mar 7,2024
produce: a program that outputs
 */

//imports
import java.util.ArrayList;
import java.util.Scanner;

//The main class
public class Main {
    static ArrayList<Maintenance> maintenanceList = new ArrayList<>();
    static ArrayList<Car> carList = new ArrayList<>();
    static ArrayList<Service> serviceList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int your_choice;
        do {
            System.out.println("Add Maintenance");
            System.out.println("Show Maintenance by Invoice");
            System.out.println("Show all maintenance");
            System.out.println("Delete Maintenance");
            System.out.println("Exit");
            System.out.print("Enter your choice: ");
            your_choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (your_choice) {
                case 1:
                    MaintenanceTracker.addMaintenance(scanner);
                    break;
                case 2:
                    MaintenanceTracker.showMaintenanceByInvoice(scanner);
                    break;
                case 3:
                    MaintenanceTracker.showAllMaintenance();
                    break;
                case 4:
                    MaintenanceTracker.deleteMaintenance(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (your_choice != 6);
        scanner.close();
    }
}