package search;

public class BinarySearchTemplates {

    /**
     * The end condition here is start > end or start = end + 1. This is mostly used for equality.
     */
    static int templateI(int[] r, int target) {
        int start = 0;
        int end = r.length - 1;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (r[middle] > target) {
                end = middle - 1;
            } else if (r[middle] < target) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Return the smallest number m in range [start,end) so that r[middle] > target
     * The end condition here is start == end .
     * <p>
     * Remember that the range we are searching in should always be shrinking. This means:
     * If we are using r[middle] > target as the search condition and there are only two elements
     * left in the search range, the range will NOT shrink and we will end up in an infinite loop.
     * Let's assume that the range is between [0,1]. The middle will be (1-0)/2 +0 = 0. Let's also assume that
     * the array looks like this for indexes 0 and 1 : [3,15] and the target is 15. The condition (r[middle] > target)
     * will return false setting start = middle = 0. So the search range is not shrinking and we this means that we
     * fell in an infinite loop. We can avoid the infinite loop by choosing the upper middle when using the template
     * of binary search that update the start with middle
     */
    static int templateII(int[] r, int target) {

        if (r == null || r.length == 0) return -1;

        int start = 0;
        int end = r.length - 1;

        while (start < end) {
            int middle = (end - start) / 2 + start;
            if (r[middle] < target) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return end != r.length && r[end] == target ? end : -1;
    }

    static int templateIII(int[] r, int target) {

        if (r == null || r.length == 0) return -1;

        int start = 0;
        int end = r.length - 1;

        while (start < end) {
            int middle = (end - start + 1) / 2 + start;
            if (r[middle] > target) {
                end = middle - 1;
            } else {
                start = middle;
            }
        }

        return end != r.length && r[end] == target ? end : -1;
    }

    //////////////////////////////////////////////////////////////////////////////////////


    /**
     * The same as template II - only the upper bound changes here
     */
    static int templateIV(int[] r, int target) {

        if (r == null || r.length == 0) return -1;

        int start = 0;
        int end = r.length;

        while (start < end) {
            int middle = (end - start) / 2 + start;
            if (r[middle] < target) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return end != r.length && r[end] == target ? end : -1;
    }

    /**
     * Exactly the same as template II - tried to change the upper bound but this should fail since in this case
     * we are using the upper/right middle.
     */
    static int templateV(int[] r, int target) {

        if (r == null || r.length == 0) return -1;

        int start = 0;
        int end = r.length;

        while (start < end) {
            int middle = (end - start + 1) / 2 + start;
            if (r[middle] > target) {
                end = middle - 1;
            } else {
                start = middle;
            }
        }

        return end != r.length && r[end] == target ? end : -1;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // Using bitwise shift to retrieve middle point

    /**
     * TemplateII adjustment with bitwise shift for middle evaluation
     */
    static int templateVI(int[] r, int target) {

        if (r == null || r.length == 0) return -1;

        int start = 0;
        int end = r.length - 1;

        while (start < end) {
            int middle = (end + start) >>> 1;
            if (r[middle] < target) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return end != r.length && r[end] == target ? end : -1;
    }

    /**
     * Template III adjustment with bitwise shift for middle evaluation
     */
    static int templateVII(int[] r, int target) {

        if (r == null || r.length == 0) return -1;

        int start = 0;
        int end = r.length - 1;

        while (start < end) {
            int middle = (end + start + 1) >>> 1;
            if (r[middle] > target) {
                end = middle - 1;
            } else {
                start = middle;
            }
        }

        return end != r.length && r[end] == target ? end : -1;
    }


    public static void main(String[] args) {
        int[] ints = {1, 3, 7, 8, 23, 34, 45, 56, 91};
        for (int anInt : ints) {
//            System.out.println(templateI(ints,anInt));
//            System.out.println(templateII(ints, anInt));
//            System.out.println(templateIII(ints, anInt));
//            System.out.println(templateIV(ints, anInt));
//            System.out.println(templateV(ints, anInt));
//            System.out.println(templateVI(ints, anInt));
            System.out.println(templateVII(ints, anInt));
            System.out.println("=====================================");
        }

    }
}
