public class FizzBuzz {
    public static void main(String[] args) {

//        A number is a multiple of X if number ÷ X results in a remainder of zero.
//        There are three conditions for Fizz, Buzz, and FizzBuzz. Be careful about their order.
//        If something is FizzBuzz, it also satisfies the conditions for Fizz and Buzz.

        // See Learn the Part for detailed instructions.
        for (int i = 0; i < 19; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + " FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println(i + " Buzz");
            } else if (i % 3 == 0) {
                System.out.println(i + " Fizz");
            }
        }
    }

}
