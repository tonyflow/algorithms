package leetcode;

public class FirstLastOccurence {

    int[] findLinear(int[] nums, int target) {

        int[] results = new int[]{-1, -1};
        // find first
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                results[0] = i;
                break;
            }

        }

        // find last
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                results[1] = i;
                break;
            }
        }

        return results;
    }

    int[] findLogarithmic(int[] nums, int target) {

        int[] results = new int[]{-1, -1};

        results[0] = findLeftLogarithmic(nums, 0, nums.length - 1, 8);
        results[1] = findRightLogarithmic(nums, 0, nums.length - 1, 8);

        return results;
    }

    private int findRightLogarithmic(int[] nums,
                                     int low,
                                     int high,
                                     int target) {


        int index = 0;

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target >= nums[mid]) low = mid + 1;
            else high = mid - 1;

            if (nums[mid] == target) index = mid;
        }

        return index;

    }

    private int findLeftLogarithmic(int[] nums,
                                     int low,
                                     int high,
                                     int target) {

        int index = 0;

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (target <= nums[mid]) high = mid - 1;
            else low = mid + 1;

            if (nums[mid] == target) index = mid;
        }

        return index;

    }
}
