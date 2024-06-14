import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
    static Scanner scanner = new Scanner(System.in);
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        String randomWord = words[(int) (Math.random() * words.length)];
        System.out.println(randomWord);

        String[] missed = {"", "", "", "", "", ""};
        int missedCounter = 0;

        String[] hit = new String[randomWord.length()];
        Arrays.fill(hit, "_");

        while (true) {
            int hitCounter = 0;
            printGallows(missedCounter);
            printStatus(hit);
            printMissed(missed);
            String guess = askUser().substring(0,1);

            for (int i = 0; i < randomWord.length(); i++) {
                if (guess.charAt(0) == randomWord.charAt(i)) {
                    hit[i] = guess;
                    hitCounter++;
                }
            }

            if (hitCounter == 0) {
                missed[missedCounter] = guess;
                missedCounter++;
            }

            if (missedCounter == 6) {
                printGallows(6);
                System.out.println("RIP!");
                System.out.println("Word was " + randomWord);
                System.exit(0);
            }

            hitCounter = 0;
            for (String i : hit) {;
                if (i.equals("_")) {
                    break;
                } else {
                    hitCounter++;
                    if (hitCounter == randomWord.length()) {
                        System.out.println();
                        printStatus(hit);
                        System.out.println("GOOD WORK!");
                        System.exit(0);
                    }
                }
            }
        }

    }

    public static String askUser() {
        System.out.print("Guess: ");
        return scanner.next();
    }

    public static void printStatus(String[] hit) {
        System.out.print("Word:    ");
        for (String letter : hit) System.out.print(letter);
        System.out.println();
    }

    public static void printMissed(String[] missed) {
        System.out.print("Misses:    ");
        for (String letter : missed) System.out.print(letter);
        System.out.println();
    }

    public static void printGallows(int tries) {
        System.out.println(gallows[tries]);
    }

}





