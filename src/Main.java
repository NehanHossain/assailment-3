/* ***************************************
course: COSC1200
Name: Nehan Hossain
Mar 7,2024
produce: a program that outputs
 */

// imports
import java.util.ArrayList;
import java.util.Scanner;

// Main class
public class Main {

    // constants
    final Integer ONE = 1;
    final Integer TWO = 2;
    final Integer THREE = 3;
    final Integer FOUR = 4;
    final Integer FIVE = 5;
    final Integer SIX = 6;

    int count = 0;

    //Array Lists
    static ArrayList<Maintenance> maintenanceList = new ArrayList<>();
    static ArrayList<Car> carList = new ArrayList<>();
    static ArrayList<Service> services = new ArrayList<>();

    static {
        services.add(new Service("OCF2","Foreign Oil/Filter","Foreign oil change and filter replacement",109.99f,30,true));
        services.add(new Service("OCD2","Domestic Oil/Filter","Domestic oil change and filter replacement",79.99f,30,true));
        services.add(new Service("TR01","Tire Rotation and Balance","Clockwise Rotation of 4 tires with balancing",59.99f,30,true));
        services.add(new Service("WB01","Wiper Blade Inspection","Inspect wiper blades for cracks and defects",9.99f,5,true));
        services.add(new Service("AF02","Air Filter Replacement","Replace engine air filter",29.99f,10,true));
        services.add(new Service("TF02","Transmission Fluid Flush","Flush and replace transmission fluid",79.99f,40,true));
        services.add(new Service("BFF2","Brake Fluid Flush","Flush and replace brake fluid",69.99f,30,true));
        services.add(new Service("BP01","Brake Inspection","Inspect brakes for percentage remaining and unusual wear and tear.",34.99f,15,true));
        services.add(new Service("BPF2","Front Brake Pad Replacement","Replace front brake pads",119.00f,60,true));
        services.add(new Service("BPR2","Rear Brake Pad Replacement","Replace rear brake pads",119.00f,60,true));
        services.add(new Service("SP02","Spark Plug Replacement","Replace spark plugs, includes plugs",104.99f,30,true));
        services.add(new Service("SA01","Steering Alignment","Align front wheels for steering",59.99f,30,true));
        services.add(new Service("RA02","Radio Installation","Install new custom radio",99.99f,60,true));
        services.add(new Service("TB02","Timing Belt Replacement","Replace timing belt",349.99f,300,true));
        services.add(new Service("WI01","Winter Undercoating","Undercoating for rust proofing/winterization",119.00f,45,true));
        services.add(new Service("WT02","Winter Tire Installation","Install 4 winter tires with balance",79.99f,60,true));
        services.add(new Service("WF01","Washer Fluid Top-up","Top-up washer fluid",0.00f,5,true));

        carList.add(new Car(10,2022,"Honda","Civic","DX","Black","Clint MacDonald"));
        carList.add(new Car(20,2019,"Acura", "MDX", "", "Silver","John Glenn"));
        carList.add(new Car(30,2022,"Ford","Mustang","GT","Red","Ford Canada"));
        carList.add(new Car(40,2020,"Toyota","Camry","Hybrid","Blue","Raj Patel"));
        carList.add(new Car(50,2018,"Jeep","Wrangler","Sahara","Green","Sarah Smith"));
        carList.add(new Car(60,2017,"Chevrolet","Silverado","1500","Gray","Gerry McLeod"));
        carList.add(new Car(70,2023,"Subaru","Outback","Limited","White","Christina McGlaughlin"));
        carList.add(new Car(80,2016,"Porsche","911","Carrera","Yellow","Bob Spears"));
        carList.add(new Car(90,2024,"Audi","A4","Quattro","Dark Blue","Stephen Forbes"));
        carList.add(new Car(100,2025,"Tesla","Model S","Plaid","Midnight Silver","Jennifer Short"));
    }

    // main interface
    public static void main(String[] args) {

        final int ONE = 1;
        final int TWO = 2;
        final int THREE = 3;
        final int FOUR = 4;
        final int FIVE = 5;
        final int SIX = 6;

        Scanner scanner = new Scanner(System.in);
        int yourChoice;
        do {
            System.out.println("1. Add Maintenance");
            System.out.println("2. Show Maintenance by Invoice");
            System.out.println("3. Show all maintenance");
            System.out.println("4. Delete Maintenance");
            System.out.println("5. show all services and cars");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            yourChoice = scanner.nextInt();
            scanner.nextLine();
            switch (yourChoice) {
                case ONE :
                    MaintenanceTracker.addMaintenance(scanner, maintenanceList, carList, services);
                    break;
                case TWO :
                    MaintenanceTracker.showMaintenanceByInvoice(scanner, maintenanceList);
                    break;
                case THREE:
                    MaintenanceTracker.showAllMaintenance(maintenanceList);
                    break;
                case FOUR:
                    MaintenanceTracker.deleteMaintenance(scanner, maintenanceList);
                    break;
                case FIVE:
                    System.out.println(services);
                    System.out.println(carList);
                    break;
                case SIX:
                    System.out.println("in progress");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (yourChoice != SIX);
        scanner.close();
    }
}
