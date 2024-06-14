public class Car {
    String make;
    double price;
    int year;
    String color;

    public Car(String make, double price, int year, String color) {
        this.make = make;
        this.price = price;
        this.year = year;
        this.color = color;
    }

    public void drive() {
        System.out.println("Driving towards nearest exit");
    }
}
