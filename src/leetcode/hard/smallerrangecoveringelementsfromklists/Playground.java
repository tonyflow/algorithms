package leetcode.hard.smallerrangecoveringelementsfromklists;

import java.util.Arrays;
import java.util.List;

public class Playground {

    public static void main(String[] args) {
        SmallerRangeCoveringElementsFromKLists smallerRangeCoveringElementsFromKLists = new SmallerRangeCoveringElementsFromKLists();
        //[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        List<List<Integer>> a = Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20), Arrays.asList(5, 18, 22, 30));
        List<List<Integer>> c = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        // [[1,3,5,7,9],[2,4,6,8,10]]
//        List<List<Integer>> b = Arrays.asList(Arrays.asList(1,3,5,7,9), Arrays.asList(0, 9, 12, 20), Arrays.asList(2,4,6,8,10));
        System.out.println(Arrays.toString(smallerRangeCoveringElementsFromKLists.smallestRange(c)));
    }
}
