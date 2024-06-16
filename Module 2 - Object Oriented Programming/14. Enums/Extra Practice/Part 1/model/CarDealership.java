package model;

import java.util.ArrayList;

public class CarDealership {
    private ArrayList<Car> cars;

    public CarDealership() {
        this.cars = new ArrayList<>();
    }

    public Car getCar(int index) {
        return new Car(cars.get(index));
    }

    public void setCar(Car source, int index) {
         cars.set(index, new Car(source));
    }

    public void addCar(Car source) {
        cars.add(new Car(source));
    }

}