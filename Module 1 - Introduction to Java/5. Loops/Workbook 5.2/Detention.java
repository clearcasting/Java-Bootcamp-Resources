import java.util.Scanner;

public class Detention {
    public static void main(String[] args) {

        System.out.println("Hi Bart. I can write lines for you.\nWhat do you want me to write?");
        // See Learn the Part for the instructions.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi Bart. I can write lines for you.");
        System.out.println("What do you want me to write?");

        String answer = scanner.nextLine();
        for (int i = 1; i < 100; i++) {
            System.out.println(i + ". " + answer);
        }
    }
}
