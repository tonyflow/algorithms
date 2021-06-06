package leetcode.floodfill;

public class Playground {

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        floodFill.floodFill(image, 1, 1, 1);

    }
}
