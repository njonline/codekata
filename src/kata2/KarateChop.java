package kata2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KarateChop {

    /**
     * Take int as input and target
     * Search through sorted array
     * Return position of int in array
     * Return -1 if not in array
     */

    /**
     * Uses 'contains' on array
     * @param target
     * @param array
     * @return
     */
    public int chop1(int target, int[] array) {

        for(int i = 0; i < array.length; i++) {
            if(Arrays.asList(array[i]).contains(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Simple for-loop
     * @param target
     * @param array
     * @return
     */
    public int chop2(int target, int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(target == array[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Uses Java 8 streams and lambda functions
     * Creates a stream going from 0 to the length of the array
     * Filters all instances of i, where the value of the position of i in the array == target
     * Adds index position to new array called index
     * @param target
     * @param array
     * @return the first number in the new array, or -1 if out of bounds
     */
    public int chop3(int target, int[] array) {
        try {
            int[] index = IntStream.range(0, array.length)
                    .filter(i -> array[i] == target)
                    .toArray();
            return index[0];
        } catch(ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }

    /**
     * Same as above with simple if-condition instead of exception
     * @param target
     * @param array
     * @return
     */
    public int chop4(int target, int[] array) {
        int[] index = IntStream.range(0, array.length)
                .filter(i -> array[i] == target)
                .toArray();

        if(index.length == 0) {
            return -1;
        }
        return index[0];
    }


    /**
     * While loop
     */
    public int chop5(int target, int[] array) {
        int i = 0;
        while(i < array.length) {
            if(target == array[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
