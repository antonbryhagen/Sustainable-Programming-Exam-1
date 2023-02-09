package Example1;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Instant start = Instant.now();
        SecureRandom random = new SecureRandom();
        OptionalDouble optDouble = random.ints(5000000, 1, 100)
                .parallel()
                .average();
        double average = optDouble.getAsDouble();
        Instant stop = Instant.now();
        Duration timeToRun = Duration.between(start, stop);
        System.out.println("Time to run " + timeToRun.toMillis());
        System.out.println("Average: " + average);

    }
}
