public class Beer {
    public static void main(String[] args) {
       // See detailed instructions on Learn the Part.
        for (int i = 99; i > 0; i--) {
            sing(i);
        }
    }

    public static void sing(int i) {
        System.out.printf("""
                %d bottles of beer on the wall, %d bottles of beer!
                take one down, pass it around, %d bottles of beer on the wall!%n
                """, i, i, i-1);
    }
}
