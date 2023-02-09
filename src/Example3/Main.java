package Example3;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/*
    Example showing performance of parallel streams
    1+2+3+4+...+n
    Can test performance by removing parallel() and compare time
 */

public class Main {
    public static void main(String[] args) {

        int n = 2_000_000_000;

        Instant start = Instant.now();
        long result = LongStream.rangeClosed( 1, n )
                .parallel()
                .reduce(0, ( long a, long b ) -> a + b);
        Instant stop = Instant.now();
        Duration timToRun = Duration.between(start, stop);
        System.out.println("Sum: "+result);
        System.out.println("Time to run: "+timToRun.toMillis());
    }
}
