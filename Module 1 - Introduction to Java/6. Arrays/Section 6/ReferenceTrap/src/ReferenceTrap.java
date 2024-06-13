import java.util.Arrays;

public class ReferenceTrap {
    public static void main(String[] args) {
        int[] numbers = { 1, 2 , 3};

        // do not set array variables to each other it only references what is being assigned
        int[] numbers2 = numbers;
        numbers2[1] = 5;
        // changes numbers array

        String[] staffLastYear = {"Tommy", "Joel", "Ellie"};
        String[] staffThisYear = Arrays.copyOf(staffLastYear, staffLastYear.length);
        staffThisYear[1] = "Abby";


        System.out.println(Arrays.toString(staffLastYear));
        System.out.println(Arrays.toString(staffThisYear));
    }
}
