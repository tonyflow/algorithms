package leetcode.hard.countofsmallernumbersafterself;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf  {

    IndexedVal[] aux;

    class IndexedVal {
        int val;
        int index;

        public IndexedVal(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public IndexedVal clone() {
            return new IndexedVal(this.val, this.index);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        aux = new IndexedVal[nums.length];
        IndexedVal[] indexed = new IndexedVal[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result.add(0);
            indexed[i] = new IndexedVal(nums[i], i);
        }
        count(indexed, 0, indexed.length - 1, result);

        return result;
    }

    private void count(IndexedVal[] indexed,
                       int left,
                       int right,
                       List<Integer> result) {
        if (left < right) {
            int mid = (right - left) / 2 + left;
            count(indexed, left, mid, result);
            count(indexed, mid + 1, right, result);
            merge(indexed, left, mid, right, result);
        }
    }

    private void merge(IndexedVal[] indexed,
                       int left,
                       int mid,
                       int right,
                       List<Integer> result) {

        for (int k = left; k <= right; k++) aux[k] = indexed[k].clone();

        int i = left;
        int j = mid + 1;

        int k = left;
        int smallerElementsOnTheRight = 0;
        while (i <= mid || j <= right) {
            if (i > mid) {
                // we have run out of numbers in the left part. This means that all remaining numbers on the right side
                // are larger than all the numbers at the left part. We update the pointers accordingly.
                indexed[k] = aux[j].clone();
                j++;
            } else if (j > right) {
                // we have run out of numbers in the right part. This means that all remaining numbers on the left side
                // are larger than all the numbers at the right part. We update the pointers accordingly.
                indexed[k] = aux[i].clone();
                result.set(aux[i].index, result.get(aux[i].index) + smallerElementsOnTheRight);
                i++;
            } else if (aux[j].val < aux[i].val) {
                // number at j - right part - is smaller than number at i - left part.
                // As long as we keep finding smaller elements on the right part than the current element on the left
                // part we are incrementing the respective counter
                smallerElementsOnTheRight++;

                // Usual merge sort stuff
                indexed[k] = aux[j].clone();
                j++;
            } else {
                // number at i is smaller than number at j
                // This means that we have to update the counts for the number on the left part which till now was the
                // largest
                indexed[k] = aux[i].clone();
                result.set(aux[i].index, result.get(aux[i].index) + smallerElementsOnTheRight);
                i++;
            }
            k++;
        }
    }
}
