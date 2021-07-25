package leetcode.CombinationSumII;

public class Playground {

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        int[] b = {2, 5, 2, 1, 2};
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] more = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(combinationSumII.combinationSum2(a, 8));
        System.out.println(combinationSumII.combinationSum2(b, 5));
        System.out.println(combinationSumII.combinationSum2(candidates, 27));
        System.out.println(combinationSumII.combinationSum2(more, 30));
    }
}
