import product.Pants;
import product.Product;
import product.Shirt;

public class Main {

    public static void main(String[] args) {
        Shirt shirt = new Shirt(Shirt.Size.SMALL, 15.99, "BLUE", "NIKE");
        shirt.fold();

        productStore(shirt);

        Pants pants = new Pants(32, 32, 30.00, "BLACK", "LEVI'S");
        pants.fold();

        productStore(pants);
    }

    public static void productStore(Product product) {
        System.out.println("Thank you for purchasing " + product.getBrand() + " " + product.getClass().getSimpleName().toLowerCase() +  " Your total comes to " + product.getPrice());
    }
}
