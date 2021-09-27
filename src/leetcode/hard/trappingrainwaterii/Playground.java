package leetcode.hard.trappingrainwaterii;

public class Playground {

    public static void main(String[] args) {
        TrappingRainWaterII trappingRainWaterII = new TrappingRainWaterII();
        int[][] a = {
                {1, 4, 3, 1, 3, 2},
                {3, 2, 1, 3, 2, 4},
                {2, 3, 3, 2, 3, 1}
        };
        int[][] b = {
                {12, 13, 1, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}
        };
        System.out.println(trappingRainWaterII.trapRainWater(b));

    }
}
