/* ***************************************
COSC1200
Nehan Hossain
Feb 23, 2024
service
 */

//imports
import java.util.ArrayList;

public class Service {

    static ArrayList<Service> services = new ArrayList<>();

    // Constants
    final double ZEROPOINTZERO = 0.0;
    static final double ZEROPOINTZEROZERO = 0.00;
    final int FOUR = 4;
    final int FIFTY = 50;
    final double ONEHUNDRED = 100.00;
    final double FIVETHOUSEND = 5000.00;

    // Variables
    private String service_code;
    private String service_name;
    private String description;
    private double base_price;
    private double time_required;
    private boolean is_active;

    // Default Constructor
    public Service(int serviceCode, String serviceName, double price) {
        setDefaults();
    }

    // Parameterized Constructor
    public Service(String serviceCode, String serviceName, String description,
                   double basePrice, double timeRequired, boolean isActive) {
        this.service_code = serviceCode;
        this.service_name = serviceName;
        this.description = description;
        this.base_price = basePrice;
        this.time_required = timeRequired;
        this.is_active = isActive;
    }

    // Secondary Parameterized Constructor
    public Service(String serviceCode, String serviceName) {
        this(serviceCode, serviceName, "", 0.00, 0.00, false);
    }

    // Getters
    public String getServiceCode() {
        return service_code;
    }

    public String getServiceName() {
        return service_name;
    }

    public String getDescription() {
        return description;
    }

    public double getBasePrice() {
        return base_price;
    }

    public double getTimeRequired() {
        return time_required;
    }

    public boolean isActive() {
        return is_active;
    }

    // Setters
    public void setServiceCode(String serviceCode) {
        if (serviceCode != null && serviceCode.length() == FOUR) {
            this.service_code = serviceCode;
        }
    }

    public void setServiceName(String serviceName) {
        if (serviceName != null && serviceName.length() <= FIFTY) {
            this.service_name = serviceName;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice >= ZEROPOINTZEROZERO && basePrice <= FIVETHOUSEND) {
            this.base_price = basePrice;
        }
    }

    public void setTimeRequired(double timeRequired) {
        if (timeRequired >= ZEROPOINTZEROZERO && timeRequired <= ONEHUNDRED) {
            this.time_required = timeRequired;
        }
    }

    public void setActive(boolean isActive) {
        this.is_active = isActive;
    }

    // Instance Methods
    public String toString() {
        return "Service Code: " + service_code + "\n" +
                "Service Name: " + service_name + "\n" +
                "Description: " + description + "\n" +
                "Base Price: " + base_price + "\n" +
                "Time Required: " + time_required + "\n" +
                "Is Active: " + is_active;
    }

    private void setDefaults() {
        service_name = "unknown";
        description = "";
        base_price = ZEROPOINTZEROZERO;
        time_required = ZEROPOINTZEROZERO;
        is_active = false;
    }

    // Static Methods
    public static String toTable(ArrayList<Service> services) {
        StringBuilder table = new StringBuilder();
        table.append(String.format("%-15s %-50s %-10s %-10s %-10s %-10s\n",
                "Service Code", "Service Name", "Price", "Time", "Active", "Description"));
        for (Service service : services) {
            table.append(String.format("%-15s %-50s %-10.2f %-10.2f %-10s %-10s\n",
                    service.getServiceCode(), service.getServiceName(), service.getBasePrice(),
                    service.getTimeRequired(), service.isActive(), service.getDescription()));
        }
        return table.toString();
    }

    public static Service findService(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service;
            }
        }
        return null;
    }

    public static double getServicePrice(String serviceCode, ArrayList<Service> services) {
        for (Service service : services) {
            if (service.getServiceCode().equals(serviceCode)) {
                return service.getBasePrice();
            }
        }
        return ZEROPOINTZEROZERO;
    }
}
