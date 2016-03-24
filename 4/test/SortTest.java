import java.util.Arrays;
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
    public void testSameSortedArraySize() {
        int sizeBeforeSort;
        int sizeAfterSort;

        for (int i = 0; i < arraysOfNumbers.length; i++) {
            sizeBeforeSort = arraysOfNumbers[i].length;
            Arrays.sort(arraysOfNumbers[i]);
            sizeAfterSort = arraysOfNumbers[i].length;
            assertEquals(sizeBeforeSort, sizeAfterSort);
        }
    }

    @Test
    public void testSortedValuesAlwaysIncreasing() {

        for (int i = 0; i < arraysOfNumbers.length; i++) {
            Arrays.sort(arraysOfNumbers[i]);

            for (int j = 0; j < arraysOfNumbers[i].length - 1; j++) {
                assertTrue(arraysOfNumbers[i][j] <= arraysOfNumbers[i][j + 1]);
            }
        }
    }

    @Test
    public void testIdempotency() {
        int[] arraySortedOnce;

        for (int i = 0; i < arraysOfNumbers.length; i++) {
            Arrays.sort(arraysOfNumbers[i]);
            arraySortedOnce = Arrays.copyOf(arraysOfNumbers[i],
                arraysOfNumbers[i].length);
            Arrays.sort(arraysOfNumbers[i]);

            for (int j = 0; j < arraysOfNumbers[i].length; j++) {
                assertEquals(arraySortedOnce[j], arraysOfNumbers[i][j]);
            }
        }
    }
}
