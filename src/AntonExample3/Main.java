package AntonExample3;

import java.util.Arrays;

/*
    This example shows that using some operations in a parallel stream may produce unwanted results
    since each thread gets the same instruction but different elements
 */

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5};

        int sum = Arrays.stream(numbers)
                .parallel()
                .reduce(10, Integer::sum);

        /*
            Expected sum would be 1 + 3 + 5 + 10 = 19
            But since the stream is parallel, the 10 in the reduce operation is added in each thread
            working with that instruction
         */

        System.out.printf("The sum is %d", sum);
    }
}
