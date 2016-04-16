package kata2;

/**
 * Binary search exercise
 * Basic premise:
 * 1) Input integer to search for
 * 2) Determine middle of array, and whether the middle value is > || < target value.
 * 3) Increase search to what ever half of the array, that the target value could potentially be in
 * 4) Repeat until target value is found or not in array
 */
public class ChopC implements Chop {

    @Override
    public int chop(int target, int[] array) {
        return binaryRecursion(array, 0, array.length - 1, target);
    }

    private int binaryRecursion(int[] array, int min, int max, int target) {
        int mid = (min + max) / 2;

        if(min > max) return -1;

        if(array[mid] == target) {
            return mid;
        } else if(target < array[mid]) {
            return binaryRecursion(array, min, mid - 1, target);
        } else {
            return binaryRecursion(array, mid + 1, max, target);
        }
    }
}
