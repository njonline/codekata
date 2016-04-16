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

        if(array.length == 1) {
            if(array[0] == target) return 0;
        }

        if(array.length > 1) {
            int min = 0;
            int max = array.length - 1;
            int[] sub_array;
            for(int i = min; i <= max; i++) {
                int mid = (int) Math.floor((min + max) / 2);
                if(array[mid] == target) {
                    return mid;
                } else {
                    if (array[mid] < target) {
                        if(mid % 2 == 0) {
                            sub_array = new int[mid];
                        } else {
                            sub_array = new int[mid + 1];
                        }
                        //min = mid + 1;
                        for (int x = 0; x <= sub_array.length; x++) {
                            sub_array[i] = array[mid + 1 + x];
                        }
                    } else {
                        if(mid % 2 == 0) {
                            sub_array = new int[mid];
                        } else {
                            sub_array = new int[mid + 1];
                        }
                        //max = mid - 1;
                        for (int x = 0; x <= sub_array.length; x++) {
                            sub_array[i] = array[x];
                        }
                    }
                    chop(target, sub_array);
                }
            }
        }

        /**
         *
         * array.length = 3;
         * mid.floor = 1;
         * ny.length = 2 (mid + 1);
         *
         *array.length = 4;
         * mid.floor = 2;
         * ny.length = 2;
         *
         */

        return -1;
    }
}
