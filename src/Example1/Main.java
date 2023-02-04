package Example1;

import java.security.SecureRandom;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        SecureRandom random = new SecureRandom();
        OptionalDouble optDouble = random.ints(60000000, 1, 100).parallel()
                .average();
        double average = optDouble.getAsDouble();
        System.out.println("Average: " + average);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time: " + duration/1000000000 + " seconds");
    }
}
