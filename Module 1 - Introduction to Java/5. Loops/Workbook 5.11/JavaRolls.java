import java.util.Scanner;

public class JavaRolls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // See Learn the Part for detailed instructions.
        int diceRoll;
        int score = 0;

        System.out.println("Let's play Rolling Java. Type anything to start.");
        scan.nextLine();
        System.out.println("""
                Great, here are the rules:
                - If you roll a 6, the game stops.
                - If you roll a 4, nothing happens.
                - Otherwise, you get 1 point.
                You must collect at least 3 points to win. Enter anything to roll:
                """);
        boolean flag = true;
        while (flag) {
            diceRoll = rollDice();
            scan.nextLine();
            System.out.print("You rolled a " + diceRoll + ". ");

            switch(diceRoll) {
                case 6 -> {
                    System.out.println("End of game.");
                    flag = false;
                }
                case 4 -> System.out.println("Zero points. Keep rolling.");
                default -> {
                    System.out.println("One point. Keep rolling.");
                    score++;
                }
            }
        }
        if (score >= 3) {
            System.out.println("Wow, that's lucky. You win!");
        } else {
            System.out.println("Tough luck, you lose :(");
        }


    }
    public static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
  
  

  
  
}
