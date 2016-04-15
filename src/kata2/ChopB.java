package kata2;

/**
 * Binary search exercise
 * Basic premise:
 * 1) Input integer to search for
 * 2) Determine middle of array, and whether the middle value is > || < target value.
 * 3) Increase search to what ever half of the array, that the target value could potentially be in
 * 4) Repeat until target value is found or not in array
 */
public class ChopB implements Chop {

    @Override
    public int chop(int target, int[] array) {

        if (array.length > 0) {
            int min = 0;
            int max = array.length -1;

            do {
                int mid = (int) Math.floor((min + max) / 2);
                if(array[mid] < target) {
                    min = mid + 1;
                } else if(array[mid] > target) {
                    max = mid - 1;
                } else {
                    return mid;
                }

            } while (min <= max);
        }

        return -1;
    }
}
