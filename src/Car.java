/* ***************************************
course: COSC1200
Name: Nehan Hossain
Mar 7,2024
produce: Car
 */

//imports
import java.util.ArrayList;

public class Car {

    public static ArrayList<Car> cars;
    private static int autoVin = 1;

    private int vin;
    private int year;
    private String make;
    private String model;
    private String trim;
    private String color;
    private String owner;

    // Constructors
    public Car(String vin) {}

    public Car(int vin, int year, String make, String model,
               String trim, String color, String owner) {
        setVin(vin);
        setYear(year);
        setMake(make);
        setModel(model);
        setTrim(trim);
        setColor(color);
        setOwner(owner);
    }

    // Getters
    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getTrim() {
        return trim;
    }

    public String getColor() {
        return color;
    }

    public String getOwner() {
        return owner;
    }

    // Setters
    public void setVin(int vin) {
        if (vin == 0) {
            vin = autoVin++;
        }
        this.vin = vin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Instance Methods
    public void printCar() {
        System.out.println(String.format("""
                 -------------------------------
                 vin: %d - %s %d %s %s %s
                    owner: %s
                 -------------------------------
                 """, getVin(), getColor(), getYear(), getMake(), getModel(), getTrim(), getOwner()));
    }

    // Static Methods
    public static Car findCarByVIN(int vin, ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.getVin() == vin) {
                return car;
            }
        }
        return null;
    }

    public static String toTable(ArrayList<Car> cars) {
        StringBuilder table = new StringBuilder();
        table.append("VIN | COLOR    | YEAR | Make | Model | Owner\n");
        table.append("----|----------|------|------|-------|---------------------\n");
        for (Car car : cars) {
            table.append(String.format("%-4d| %-9s| %-5d| %-5s| %-6s| %-20s\n",
                    car.getVin(), car.getColor(), car.getYear(), car.getMake(), car.getModel(), car.getOwner()));
        }
        return table.toString();
    }

    public String toString(int vin) {
        Car car = findCarByVIN(vin, cars);
        if (car != null) {
            return car.toString();
        }
        return "Car not found!";
    }
}
