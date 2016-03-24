import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SortTest {

    static int[][] arraysOfNumbers;

    @BeforeClass
    public static void setUpOnce() {
        Random rng = new Random();

        // create an array of random array sizes
        int numberOfArrays = 100;
        IntStream randomSizes = rng.ints(numberOfArrays, 1, 1000);
        int[] arraySizes = randomSizes.toArray();

        // create arrays of random numbers
        arraysOfNumbers = new int[numberOfArrays][];
        for (int i = 0; i < arraysOfNumbers.length; i++) {
            IntStream randomNumbers = rng.ints(arraySizes[i], -1000, 1000);
            arraysOfNumbers[i] = randomNumbers.toArray();
        }
    }

    @Test
    public void doNothing() {
    }
}
