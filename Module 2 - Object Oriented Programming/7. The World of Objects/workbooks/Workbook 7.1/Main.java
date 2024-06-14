import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Johnny";
        System.out.println(person.name);

        person.nationality = "British";
        System.out.println(person.nationality);

        person.dateOfBirth = "01/01/2001";
        System.out.println(person.dateOfBirth);

        person.passport = new String[]{
                person.name, person.nationality, person.dateOfBirth
        };
        System.out.println(Arrays.toString(person.passport));

        person.seatNumber = 38;
        System.out.println(person.seatNumber);
    }
}
