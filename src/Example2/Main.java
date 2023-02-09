package Example2;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        SecureRandom random = new SecureRandom();
        int[] ints = random.ints(100000000, 1, 1001).toArray();
        OptionalInt optDouble = Arrays.stream(ints).parallel()
                .map(x -> x * 10 - 3000)
                .filter(x -> x > 4000)
                .distinct()
                .sorted()
                .findFirst();
        int average = optDouble.getAsInt();
        System.out.println("Average: " + average);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration/1000000000 + " seconds");
    }
}