package hackerrank;

import java.util.Scanner;

public class ConstructiveAlgorithms {

  /**
   * Flipping the Matrix.
   */
  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int q = in.nextInt();

    for (int i = 0; i < q; i++) {
      int n = in.nextInt();
      int[][] sean = new int[2 * n][2 * n];
      for (int j = 0; j < 2 * n; j++) {
        for (int k = 0; k < 2 * n; k++) {
          sean[j][k] = in.nextInt();
        }
      }

      System.out.println(solve(sean));
    }

  }

  private static int solve(int[][] sean) {

    int max = 0;
    int n = sean.length / 2;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        max += Math.max(Math.max(
            Math.max(sean[i][j],
                sean[i][sean.length - 1 - j]),
            sean[sean.length - 1 - i][sean.length - 1 - j]
            ),
            sean[sean.length - 1 - i][j]);

      }
    }

    return max;

  }


}
