import model.BodyType;
import model.Car;
import model.CarDealership;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String make = promptForMake(scanner);
        String model = promptForModel(scanner);
        BodyType bodyType = promptForBodyType(scanner);
        int year = promptForYear(scanner);
        double price = promptForPrice(scanner);


        Car newCar = new Car(make, model, bodyType, year, price);


        CarDealership dealership = new CarDealership();
        dealership.addCar(newCar);


        System.out.println("Car added to the dealership: " + newCar.getMake() + " " + newCar.getModel());



    }

    public static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean invalidYear(int year) {
        return year < Car.MIN_YEAR;
    }

    public static boolean invalidPrice(double price) {
        return price < Car.MIN_PRICE || price > Car.MAX_PRICE;
    }

    public static boolean invalidBodyType(String bodyType) {
        BodyType.valueOf(bodyType);
        return true;
    }

    public static BodyType promptForBodyType(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car body type: ");
            String bodyType = scanner.nextLine().toUpperCase();

            try {
                invalidBodyType(bodyType);
            } catch (IllegalArgumentException exception){
                System.out.println("Invalid body type");
                continue;
            }

            return BodyType.valueOf(bodyType);
        }
    }

    public static String promptForMake(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car make: ");
            String make = scanner.nextLine();
            if (isNullOrBlank(make)) {
                System.out.println("Make cannot be null or blank.");
                continue;
            }
            return make;
        }
    }

    public static String promptForModel(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car model: ");
            String model = scanner.nextLine();

            if (isNullOrBlank(model)) {
                System.out.println("Model cannot be null or blank.");
                continue;
            }

            return model;
        }
    }

    public static int promptForYear(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid production year: ");

            if(scanner.hasNextInt()) {
                int year = scanner.nextInt();
                if (!invalidYear(year)) {
                    return year;
                }
                System.out.println("Please enter a year higher than 1900");
            } else {
                System.out.println("Please enter an integer.");
                scanner.next();
            }

        }
    }

    public static double promptForPrice(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid car price: ");

            if (scanner.hasNextDouble()) {
                double price = scanner.nextDouble();
                if (!invalidPrice(price)) {
                    return price;
                }
                System.out.println("Please enter a valid price");
            } else {
                System.out.println("Please enter a double.");
                scanner.next();
            }
        }
    }
}