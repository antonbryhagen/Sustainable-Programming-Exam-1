package Example2;

import java.util.Arrays;
/*
    This example show that you cannot control the order of which the elements are processed
    by printing the same array of ints twice, resulting in different outputs
 */

public class Main {
    public static void main(String[] args) {
        int[] someNumbers = {3, 6, 12, 5, 62, 12, 15, 42, 23};

        Arrays.stream(someNumbers)
                .parallel()
                .forEach(number -> System.out.print(number + " "));

        System.out.println();

        Arrays.stream(someNumbers)
                .parallel()
                .forEach(number -> System.out.print(number + " "));
    }
}
