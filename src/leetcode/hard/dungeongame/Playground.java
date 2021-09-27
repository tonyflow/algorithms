package leetcode.hard.dungeongame;

public class Playground {

    public static void main(String[] args) {
        DungeonGame dungeonGame = new DungeonGame();
        int[][] a = {
                {-2,-3,1,},
                {-5,-10,1},
                {10,30,-5}
        };
        System.out.println(dungeonGame.calculateMinimumHP(a));
    }
}
