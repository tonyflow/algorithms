package leetcode.kthsmallestelementinasortedmatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int kthSmallestBetter(int[][] matrix, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> matrix[n.row][n.col]));

        for (int i = 0; i < matrix[0].length; i++) {
            queue.add(new Node(i, 0));
        }

        int numberCount = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            result = matrix[polled.row][polled.col];
            if (++numberCount == k)
                break;

            if (polled.col < matrix.length - 1)
                queue.add(new Node(polled.row, polled.col + 1));
        }

        return result;
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int keep = k;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                queue.add(matrix[i][j]);
            }
        }

        while (k - 1 > 0) {
            queue.poll();
            k--;
        }

        return queue.poll();
    }
}
