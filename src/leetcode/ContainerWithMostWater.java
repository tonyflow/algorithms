package leetcode;

public class ContainerWithMostWater {

    static public int maxArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    static int maxAreaOptimized(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int maxArea = 0;
        while (i != j) {
            maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));
            if (heights[i] < heights[j]) i++;
            else j--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int max = ContainerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int optimum = ContainerWithMostWater.maxAreaOptimized(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(max);
        System.out.println(optimum);
    }
}
