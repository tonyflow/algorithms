package leetcode.hard.cherrypickup;

public class Playground {

    public static void main(String[] args) {
        int[][] a = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}
        };

        int[][] b = {
                {1, 1, -1},
                {1, -1, 1},
                {-1, 1, 1}
        };

        CherryPickUp cherryPickUp = new CherryPickUp();
        cherryPickUp.cherryPickup(b);
    }
}
