package shape;

public class Cylinder extends Shape {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        setHeight(height);
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
  
}
  