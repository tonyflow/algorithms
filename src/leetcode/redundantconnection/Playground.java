package leetcode.redundantconnection;

import java.util.Arrays;

public class Playground {

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(redundantConnection.findRedundantConnection(edges)));

    }
}
