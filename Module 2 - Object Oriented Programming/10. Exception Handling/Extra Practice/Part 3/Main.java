import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String title = promptForTitle(scanner);
        String publisher = promptForPublisher(scanner);
        int issueNumber = promptForIssueNumber(scanner);
        int publicationYear = promptForPublicationYear(scanner);


        Magazine newMagazine = new Magazine(title, publisher, issueNumber, publicationYear);


        MagazineLibrary library = new MagazineLibrary();
        library.addMagazine(newMagazine);


        System.out.println("Magazine added to the library: " + newMagazine.getTitle());

    }

    public static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean incorrectIssueNumber(int issueNumber) {
        return issueNumber <= 0;
    }

    public static boolean incorrectPublicationYear(int publicationYear) {
        return publicationYear <= 0;
    }

    public static String promptForTitle(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid title: ");
            String title = scanner.nextLine();

            if (!isNullOrBlank(title)) {
                return title;
            } else {
                System.out.println("Title cannot be null or blank");
            }
        }
    }

    public static String promptForPublisher(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid publisher: ");
            String publisher = scanner.nextLine();

            if (!isNullOrBlank(publisher)) {
                return publisher;
            } else {
                System.out.println("Publisher cannot be null or blank");
            }
        }
    }

    public static int promptForIssueNumber(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter an issue number greater than 0: ");
            try {
                if (scanner.hasNextInt()) {
                    int issueNumber = scanner.nextInt();
                    if (!incorrectIssueNumber(issueNumber)) {
                        return issueNumber;
                    } else {
                        System.out.println("Issue number must be higher than 0");
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Please enter an integer value");
                scanner.nextLine();
            }
        }
    }

    public static int promptForPublicationYear(Scanner scanner) {
        while (true) {
            System.out.print("\nPlease enter a valid publication year ( greater than 0): ");
            try {
                if (scanner.hasNextInt()) {
                    int publicationYear = scanner.nextInt();
                    if(!incorrectPublicationYear(publicationYear)) {
                        return publicationYear;
                    } else {
                        System.out.println("Publication year must be greater than 0");
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("Please enter an integer value");
                scanner.nextLine();
            }
        }
    }
}