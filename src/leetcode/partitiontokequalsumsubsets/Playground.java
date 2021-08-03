package leetcode.partitiontokequalsumsubsets;

public class Playground {

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets partitionToKEqualSumSubsets = new PartitionToKEqualSumSubsets();
        int[] test = {4, 3, 2, 3, 5, 2, 1};
        int[] error = {1, 2, 2, 2, 2};
        int[] foo = {1, 1, 1, 1, 2, 2, 2, 2};
        System.out.println(partitionToKEqualSumSubsets.canPartitionKSubsets(foo, 2));
    }
}
