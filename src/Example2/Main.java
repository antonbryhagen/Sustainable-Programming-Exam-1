package Example2;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        SecureRandom random = new SecureRandom();
        long[] ints = random.longs(100000000, 1, 1001).toArray();
        OptionalDouble optDouble = Arrays.stream(ints).parallel()
                .map(x -> Math.round(Math.pow(x, 2) / 10))
                .filter(x -> (x & 2) == 0)
                .distinct()
                .sorted()
                .average();
        double average = optDouble.getAsDouble();
        System.out.println("Average: " + average);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration/1000000000 + " seconds");
    }
}
