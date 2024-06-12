import java.util.Scanner;

public class CounterTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("I hear you like to count by threes\n");
        System.out.println("Jimmy: It depends.");
        System.out.println("Oh, ok...");

        System.out.println("1. Pick a number to count by: ");
        int iterator = scan.nextInt();

        System.out.println("2. Pick a number to start counting from: ");
        int min = scan.nextInt();

        System.out.println("3. Pick a number to count to: ");
        int max = scan.nextInt();

        for (int i = min; min <= max; min += iterator) {
            System.out.print(min + " ");
        }

       // See detailed instructions on Learn the Part.

        scan.close();
    }
}
