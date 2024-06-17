import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
        // Creating Stream from Datasource: Array
        String[] greetings = new String[]{"Hello!", "Hola!", "Bonjour!", "Hallo!"};
        Arrays.stream(greetings).forEach(System.out::println);

        // Creating Stream from Datasource: File
        System.out.println("\n");
        try {
            Path path = Paths.get("chorus.txt");
            Files.lines(path).forEach(System.out::println);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}