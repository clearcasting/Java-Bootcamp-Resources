import product.Pants;
import product.Shirt;

public class Main {

    public static void main(String[] args) {
        Shirt shirt = new Shirt();
        shirt.setSize(Shirt.Size.SMALL);
        shirt.setBrand("NIKE");
        shirt.setColor("BLUE");
        shirt.setPrice(49.99);
        shirt.fold();

        Pants pants = new Pants();
        pants.setWaist(32);
        pants.setLength(32);
        pants.setColor("BLACK");
        pants.setPrice(79.99);
        pants.setBrand("LEVI'S");
        pants.fold();
    }

}
