package search;

public class BinarySearch {

    public boolean find(int value, int[] r) {
        return find(value, 0, r.length - 1, r);
    }

    private boolean find(int value,
                         int low,
                         int high,
                         int[] r) {

        if (low <= high) {
            int mid = (high - low) / 2 + low;
            if (value > r[mid]) return find(value, mid + 1, high, r);
            else if (value < r[mid]) return find(value, low, mid - 1, r);
            else return true;
        }
        return false;
    }

    public boolean findIterative(int[] r, int value) {
        return findIterative(r, 0, r.length - 1, value);
    }

    private boolean findIterative(int[] r,
                                  int low,
                                  int high,
                                  int value) {

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (value < r[mid]) {
                high = mid - 1;
            } else if (value > r[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private int oo(int[] nums,int target){
         int low=0;
         int high=nums.length;

         while (low<=high){
             int middle = (high-low)/2;
             if(target<nums[middle]) high=middle-1;
             else if(target>nums[middle]) low=middle+1;
             else return middle;
         }

         return -1;
    }
}
