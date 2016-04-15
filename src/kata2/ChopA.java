package kata2;

import java.util.Arrays;

/**
 * Binary search exercise
 * Basic premise:
 * 1) Input integer to search for
 * 2) Determine middle of array, and whether the middle value is > || < target value.
 * 3) Increase search to what ever half of the array, that the target value could potentially be in
 * 4) Repeat until target value is found or not in array
 */
public class ChopA implements Chop {

    /**
     * Basic Binary Search Algorithm
     * @param target
     * @param array
     * @return
     */

    @Override
    public int chop(int target, int[] array) {

        int min = 0;
        int max = array.length - 1;

        while(min <= max) {
            int mid = (int) Math.floor((min + max) / 2);
            if(array[mid] == target) {
                return mid;
            } else if(array[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return -1;
    }

}
