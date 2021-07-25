package leetcode.HouseRobberII;

public class Playground {

    public static void main(String[] args) {
        HouseRobberII robber = new HouseRobberII();
        int[] houses = {1, 3, 2};
        int[] zeroes = {1, 4};
        int[] fail = {1, 2, 1, 1};
        System.out.println(robber.rob(fail));
//        System.out.println(robber.rob(hous));
    }
}
