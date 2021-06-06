package leetcode;

public class FlippingAnImage {

    // in place
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int start = 0;
            int end = image[i].length - 1;
            while (start < end) {
                int tmp = image[i][start];
                image[i][start] = image[i][end];
                image[i][end] = tmp;
                image[i][start] = image[i][start] == 1 ? 0 : 1;
                image[i][end] = image[i][end] == 1 ? 0 : 1;
                start++;
                end--;
            }
            if (image[i].length % 2 != 0) image[i][start] = image[i][start] == 1 ? 0 : 1;

        }
        return image;
    }

    public int[][] flipAndInvertImage2(int[][] image) {
        int[][] result = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            int originalCol = image[i].length - 1;
            int resultCol = 0;
            while (originalCol >= 0 && resultCol < result[0].length) {
                result[i][resultCol] = image[i][originalCol] == 1 ? 0 : 1;
                originalCol--;
                resultCol++;
            }
        }
        return result;
    }
}
