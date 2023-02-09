package Example1;

import java.util.ArrayList;
import java.util.Arrays;

/*
    This example shows the two ways to create a parallel streams by taking a list
    of integers and getting the sum of them
 */

public class Main {
    public static void main(String[] args) {

        /*
            Using parallelStream() method to create a parallel stream
         */
        ArrayList<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(3);
        listOfIntegers.add(5);
        listOfIntegers.add(8);

        int sumParallelStream = listOfIntegers.parallelStream()
                .mapToInt(x -> x)
                .sum();

        System.out.printf("The sum of the integers in the ArrayList is %d \n", sumParallelStream);

        /*
            Using parallel() method to create a parallel stream from a normal stream
         */

        int[] arrayOfIntegers = {1, 3, 5, 8};

        int sumParallel =  Arrays.stream(arrayOfIntegers)
                .parallel()
                .sum();

        System.out.printf("The sum of the integers in the array is %d", sumParallel);
    }
}
