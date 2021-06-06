package leetcode.floodfill;

public class FloodFill {

    public int[][] floodFill(int[][] image,
                          int sr,
                          int sc,
                          int newColor) {
        if (image[sr][sc] == newColor) return image;
        doFill(image, sr, sc, newColor, image[sr][sc]);
        return image;

    }

    void doFill(int[][] image,
                int sr,
                int sc,
                int newColor,
                int startingColor) {
        if (inBounds(image, sr, sc) && image[sr][sc] == startingColor) {
            image[sr][sc] = newColor;
            doFill(image, sr + 1, sc, newColor, startingColor); // down
            doFill(image, sr - 1, sc, newColor, startingColor); // up
            doFill(image, sr, sc + 1, newColor, startingColor); // right
            doFill(image, sr, sc - 1, newColor, startingColor); // left
        }

    }

    private boolean inBounds(int[][] image, int sr, int sc) {
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length;
    }
}
