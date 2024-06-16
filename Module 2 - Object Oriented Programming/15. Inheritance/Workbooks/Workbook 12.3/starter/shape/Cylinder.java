package shape;

public class Cylinder extends Shape {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        double radius = getRadius();
        return ((2 * Math.PI) * radius * height) + (2 * Math.PI) * (radius * radius);
    }

    @Override
    public double getVolume() {
        double radius = getRadius();
        return Math.PI * (radius * radius) * height;
    }
}
  