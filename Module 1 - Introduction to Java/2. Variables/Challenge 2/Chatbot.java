//import Scanner

import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        
        //See Learn the Part for the complete instructions. 

        
        //set up scanner.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello. What is your name?");
        //Pick up user's name and store it.
        String name = scanner.nextLine();
                           
        //add new a line before asking next question. 
        System.out.printf("Hi %s! I'm Javabot. Where are you from?%n", name);
        //Pick up user's home and store it. 
                        String home = scanner.nextLine();

        //add new a line before asking next question.
        System.out.printf("I hear it's beautiful at %s! I'm from a place called Oracle%n", home);
        System.out.println("How old are you?");
        //Pick up age and store it.
        int age = scanner.nextInt();


        //add new a line before asking next question.
        System.out.printf("So you're %d, cool! I'm 400 years old.%n", age);
        System.out.println("This means I'm " + (400 / age) + " times older than you.");
        System.out.println("Enough about me. What's your favourite language? (just don't say Python)");
        //Pick up language and store it.
        scanner.nextLine(); // fix bug
        String language = scanner.nextLine();

        //add new a line here.
        System.out.printf("%s, that's great! Nice chatting with you %s. I have to log off now. See ya!", language, name);
        
        //close scanner.
        scanner.close();
        
    }
}
