package model;

public class Car {
    private String make;
    private String model;
    private BodyType bodyType;
    private int productionYear;
    private static final int MIN_YEAR = 1900;
    private static final double MIN_PRICE = 0;
    private static final double MAX_PRICE = 200000;
    private double price;

    public Car(String make, String model, BodyType bodyType, int productionYear, double price) {
        setMake(make);
        setModel(model);
        setBodyType(bodyType);
        setProductionYear(productionYear);
        setPrice(price);
    }

    public Car(Car source) {
        setMake(source.make);
        setModel(source.model);
        setBodyType(source.bodyType);
        setProductionYear(source.productionYear);
        setPrice(source.price);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        if (make == null || make.isBlank()) throw new IllegalArgumentException("Make cannot be null or blank.");
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()) throw new IllegalArgumentException("Model cannot be null or blank.");
        this.model = model;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        if (bodyType == null) throw new IllegalArgumentException("Body type cannot be null");
        this.bodyType = bodyType;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        if (productionYear <= MIN_YEAR) throw new IllegalArgumentException("Year must be greater than " + MIN_YEAR);
        this.productionYear = productionYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < MIN_PRICE || price > MAX_PRICE) throw new IllegalArgumentException("Price must be between " + MIN_PRICE + " and " + MAX_PRICE);
        this.price = price;
    }
}