package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Search {

	/**
	 * LCA : Lowest common ancestor
	 *
	 */
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		if (root == null || root == p || root == q) {
//			return root;
//		}
//		TreeNode left = lowestCommonAncestor(root.left, p, q);
//		TreeNode right = lowestCommonAncestor(root.right, p, q);
//		return left == null ? right : right == null ? left : root;
//	}

	public static void main(String[] args) {
		System.out.println(deduplicate("cccabbbe"));

		System.out.println(removeRepetitiveChars("cccabbbe", 2));
	}

	private static String removeRepetitiveChars(String s, int n) {

		if (s == null || s.length() == 1) {
			return s;
		}

		if (checkRepetition(s, n)) {
			return removeRepetitiveChars(s.substring(n), n);
		} else {
			return s.substring(0, 1) + removeRepetitiveChars(s.substring(1), n);
		}

	}

	private static boolean checkRepetition(String s, int n) {

		char[] ca = s.toCharArray();

		for (int i = 0; i < n - 1; i++) {
			if (ca[i] != ca[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private static String deduplicate(String s) {

		if (s == null || s.length() == 1) {
			return s;
		}

		if (s.charAt(0) == s.charAt(1)) {
			return deduplicate(s.substring(1));
		} else {
			return s.substring(0, 1) + deduplicate(s.substring(1));
		}

	}

	public static int sparseString() {

		return 0;
	}

	private void missingInt() {
		BitSet bs = new BitSet();
		HashSet<String> hs = new HashSet<String>();
		Stack<Character> stack = new Stack<Character>();

	}

	private static int bruteForceSearch(String pat, String txt) {
		int j, M = pat.length();
		int i, N = txt.length();
		for (i = 0, j = 0; i < N && j < M; i++)
		{
			System.out.println("txt.charAt(" + i + ")=" + txt.charAt(i) + " pat.charAt(" + j + ")=" + pat.charAt(j));
			if (txt.charAt(i) == pat.charAt(j)) {
				j++;
			} else {
				i -= j;
				j = 0;
			}
			System.out.printf("i %d j %d \n", i, j);

		}
		if (j == M) {
			return i - M; // found
		}
		else {
			return N; // not found
		}
	}

	/**
	 * Timed out on large data sets
	 * 
	 * @param args
	 */
	public static void pairsSmallSets(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] numbers = new int[n];
		int k = s.nextInt();
		for (int i = 0; i < n; i++) {
			numbers[i] = s.nextInt();
		}

		int pairs = 0;
		for (int i = 0, j = n - 1; i <= j && j > i; i++, j--) {
			int l = 1;
			while (i + l <= j || j - l > i) {
				if (Math.abs(numbers[j] - numbers[j - l]) == k && j - l > i) {
					pairs++;
				}
				if (Math.abs(numbers[i] - numbers[i + l]) == k) {
					pairs++;
				}
				l++;
			}
		}
		System.out.println(pairs);
		s.close();
	}

	public static void pairs(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] numbers = new int[n];
		int k = s.nextInt();
		for (int i = 0; i < n; i++) {
			numbers[i] = s.nextInt();
		}

		Arrays.sort(numbers);
		int pairs = 0;
		for (int i : numbers) {
			if (Arrays.binarySearch(numbers, i + k) > 0) {
				pairs++;
			}
		}
		System.out.println(pairs);
		s.close();
	}

	/**
	 * Sherlock and Arrays
	 * 
	 * @param args
	 */
	public static void sherlockAndArrays(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {
			int N = s.nextInt();
			if (N == 1) {
				s.nextInt();
				System.out.println("YES");
				continue;
			}
			int[] A = new int[N];
			A[1] = s.nextInt();
			int[] sum = new int[N];
			sum[0] = A[1];
			int total = A[1];
			for (int j = 1; j < N; j++) {
				A[j] = s.nextInt();
				sum[j] = sum[j - 1] + A[j];
				total += A[j];
			}

			boolean found = false;
			for (int j = 1; j < N; j++) {
				if (sum[j - 1] == total - sum[j]) {
					found = true;
					break;
				}
			}
			if (found) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		s.close();
	}

	/**
	 * 
	 * @param args
	 */
	public static void iceCreamParlor(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			int M = s.nextInt();
			int N = s.nextInt();
			int[] costs = new int[N];
			for (int j = 0; j < N; j++) {
				costs[j] = s.nextInt();
			}
			int[] sortedCosts = costs.clone();
			Arrays.sort(sortedCosts);
			int firstCost = -1;
			int secondCost = -1;
			int helper = -1;
			for (int j = 0; j < N; j++) {
				if ((helper = Arrays.binarySearch(sortedCosts, j + 1, N, M
						- sortedCosts[j])) > 0) {
					firstCost = sortedCosts[j];
					secondCost = sortedCosts[helper];
					break;
				} else {
					continue;
				}
			}

			int firstIndex = -1;
			int secondIndex = -1;
			int j = 0;
			while (j <= N - 1) {
				if ((costs[j] == firstCost || costs[j] == secondCost)
						&& firstIndex == -1) {
					firstIndex = j + 1;
					j++;
					continue;
				}
				if ((costs[j] == firstCost || costs[j] == secondCost)
						&& firstIndex != -1 && secondIndex == -1) {
					secondIndex = j + 1;
					break;
				}

				j++;
			}

			System.out.println(firstIndex + " " + secondIndex);
		}
		s.close();

	}

	public static void magicNumbers(String[] args) {
		Scanner s = new Scanner(System.in);
		final int RANGE = 10_001;
		int[] cacheN = new int[RANGE];
		int[] cacheM = new int[RANGE];
		Arrays.fill(cacheN, 0);
		int n = s.nextInt();
		int[] rn = new int[n];
		for (int i = 0; i < n; i++) {
			rn[i] = s.nextInt();
			cacheN[rn[i]]++;
		}

		int m = s.nextInt();
		int[] rm = new int[m];
		for (int i = 0; i < m; i++) {
			rm[i] = s.nextInt();
			cacheM[rm[i]]++;
		}

		for (int i = 0; i < RANGE; i++) {
			if (cacheN[i] < cacheM[i]) {
				System.out.print(i + " ");
			}
		}
		s.close();
	}

	/**
	 * Maximize sum
	 * 
	 * @param args
	 */
	public static void maximizeSum(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			int N = s.nextInt();
			int M = s.nextInt();
			int[] A = new int[N];

			for (int j = 0; j < A.length; j++) {
				A[j] = s.nextInt();
			}

			if (A.length == 1) {
				System.out.println(A[0] + " " + A[0]);
				continue;
			}

			int ans = 0, sum = 0;

			for (int j = 0; j < N; j++) {
				if (sum + A[j] > 0) {
					sum += A[j];
				} else {
					sum = 0;
				}
				ans = Math.max(ans, sum % M);
			}
			System.out.println(ans);
		}

		s.close();

	}

	/**
	 * Connected cell in a grid. This implementation treats the given table as
	 * an adjacency matrix. This is a degenerate adjacency matrix since
	 * adjacency matrixes are of size |V|*|V|,G=(V,E), thus we convert this
	 * structure to an adjacency matrix by populating remaining rows and columns
	 * with zero paddings.
	 * 
	 * @param args
	 */
	public static void connectedCellsInTheGrid(String[] args) {

		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int max = m > n ? m : n;
		// int[][] adjMatrix = new int[m][n];
		Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < max; i++) {
			adjList.put(i, new ArrayList<>());
		}

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (i > m || j > n) {
					continue;
				}
				int cell = s.nextInt();
				if (cell == 1 && i != j) {
					adjList.get(i).add(j);
				}
				// adjMatrix[i][j] = s.nextInt();
			}
		}

		boolean[] traversed = new boolean[max];
		Arrays.fill(traversed, false);
		int[] distanceTo = new int[max];
		Arrays.fill(distanceTo, 0);
		int[] predecessors = new int[max];
		Arrays.fill(predecessors, -1);

		for (int i = 0; i < max; i++) {
			if (!traversed[i]) {
				dfsVisit(i, adjList, traversed, distanceTo, predecessors);
			}
		}

		Arrays.sort(distanceTo);

		s.close();

	}

	/**
	 * The following implementation of connected cells in the grid treats each
	 * "1" table entry as a different node/vertex/point of the graph against
	 * with the DFS will be performed.
	 * 
	 * @param args
	 */
	public static void connectedCellInAGrid(String[] args) {

		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] adjMatrix = new int[m][n];

		Map<String, List<String>> adjList = new HashMap<String, List<String>>();
		Map<String, Integer> distanceTo = new HashMap<>();
		Map<String, Boolean> traversed = new HashMap<>();
		Map<String, Boolean> grey = new HashMap<>();
		List<Integer> sizesOfConnectedComponents = new ArrayList<>();
		Collections.fill(sizesOfConnectedComponents, 0);

		// reading and initialization
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				adjMatrix[i][j] = s.nextInt();
				adjList.put(i + "_" + j, new ArrayList<>());
				distanceTo.put(i + "_" + j, 0);
				traversed.put(i + "_" + j, false);
				grey.put(i + "_" + j, false);
			}
		}

		// adjacency list
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (adjMatrix[i][j] == 1) {
					// upper left corner
					// right
					if (i == 0 && j == 0 && adjMatrix[i][j + 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j + 1));
					}
					// underneath
					if (i == 0 && j == 0 && adjMatrix[i + 1][j] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + j);
					}
					// diagonally
					if (i == 0 && j == 0 && adjMatrix[i + 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j + 1));
					}
					// lower left corner
					// above
					if (i == m - 1 && j == 0 && adjMatrix[i - 1][j] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + j);
					}
					// right
					if (i == m - 1 && j == 0 && adjMatrix[i][j + 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j + 1));
					}
					// diagonally
					if (i == m - 1 && j == 0 && adjMatrix[i - 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j + 1));

					}
					// upper right corner
					// left
					if (i == 0 && j == n - 1 && adjMatrix[i][j - 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j - 1));
					}
					// beneath
					if (i == 0 && j == n - 1 && adjMatrix[i + 1][j] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + j);
					}
					// diagonally
					if (i == 0 && j == n - 1 && adjMatrix[i + 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j - 1));

					}
					// lower right corner
					// above
					if (i == m - 1 && j == n - 1 && adjMatrix[i - 1][j] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + j);
					}
					// left
					if (i == m - 1 && j == n - 1 && adjMatrix[i][j - 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j - 1));
					}
					// diagonally
					if (i == m - 1 && j == n - 1
							&& adjMatrix[i - 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j - 1));
					}
				}
				// upper edge
				if (i == 0 && (j > 0 && j < n - 1) && adjMatrix[i][j] == 1) {
					// right
					if (adjMatrix[i][j + 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j + 1));
					}
					// left
					if (adjMatrix[i][j - 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j - 1));
					}
					// diagonally : down and right
					if (adjMatrix[i + 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j + 1));
					}
					// diagonally : down and left
					if (adjMatrix[i + 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j - 1));
					}
					// beneath
					if (adjMatrix[i + 1][j] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j));
					}
				}
				// lower edge
				if (i == m - 1 && (j > 0 && j < n - 1) && adjMatrix[i][j] == 1) {
					// right
					if (adjMatrix[i][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i) + "_" + (j + 1));
					}
					// left
					if (adjMatrix[i][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i) + "_" + (j - 1));
					}
					// diagonally : up and right
					if (adjMatrix[i - 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j + 1));
					}
					// diagonally : up and left
					if (adjMatrix[i - 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j - 1));
					}
					// above
					if (adjMatrix[i - 1][j] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j));
					}
				}
				// left edge
				if (j == 0 && (i > 0 && i < m - 1) && adjMatrix[i][j] == 1) {
					// above
					if (adjMatrix[i + 1][j] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j));
					}
					// beneath
					if (adjMatrix[i - 1][j] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j));
					}
					// diagonally : up and right
					if (adjMatrix[i - 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j + 1));
					}
					// diagonally : down and right
					if (adjMatrix[i + 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j + 1));
					}
					// right
					if (adjMatrix[i][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i) + "_" + (j + 1));
					}
				}
				// right edge
				if (j == n - 1 && (i > 0 && i < m - 1) && adjMatrix[i][j] == 1) {
					// above
					if (adjMatrix[i + 1][j] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j));
					}
					// beneath
					if (adjMatrix[i - 1][j] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j));
					}
					// diagonally : up and left
					if (adjMatrix[i - 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j - 1));
					}
					// diagonally : down and left
					if (adjMatrix[i + 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j - 1));
					}
					// left
					if (adjMatrix[i][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i) + "_" + (j - 1));
					}
				}

				if ((i > 0 && i < m - 1) && (j > 0 && j < n - 1)
						&& adjMatrix[i][j] == 1) { // everything
					// else
					// :
					// none
					// edge
					// related
					// cells

					// beneath
					if (adjMatrix[i + 1][j] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + j);
					}
					// up
					if (adjMatrix[i - 1][j] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j));
					}
					// right
					if (adjMatrix[i][j + 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j + 1));
					}
					// left
					if (adjMatrix[i][j - 1] == 1) {
						adjList.get(i + "_" + j).add(i + "_" + (j - 1));
					}
					// diagonally :
					// down and right
					if (adjMatrix[i + 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j + 1));
					}
					// diagonally :
					// down and left
					if (adjMatrix[i + 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i + 1) + "_" + (j - 1));
					}
					// diagonally :
					// up and
					// right
					if (adjMatrix[i - 1][j + 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j + 1));
					}
					// diagonally :
					// up and left
					if (adjMatrix[i - 1][j - 1] == 1) {
						adjList.get(i + "_" + j).add((i - 1) + "_" + (j - 1));
					}
				}

			}

		}

		// DFS
		for (String vertex : adjList.keySet()) {
			if (!traversed.get(vertex)) {
				sizesOfConnectedComponents.add(dfsVisit(vertex, adjList,
						traversed, distanceTo, grey, 1));
			}
		}

		Collections.sort(sizesOfConnectedComponents);

		System.out.println(sizesOfConnectedComponents
				.get(sizesOfConnectedComponents.size() - 1));

		// print

		s.close();

	}

	/**
	 * Count Luck : The Ron and Hermione Challenge.
	 * 
	 * @param args
	 */
	public static void ronAndHermioneChallenge(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = s.nextInt();
			int m = s.nextInt();
			int[][] terrain = new int[n][m];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					terrain[j][k] = s.nextInt();
				}
			}
		}

		s.close();

	}

	/**
	 * Every time dfsVisit is called, vertex u becomes the root of a new tree in
	 * the dipth first forest.
	 * 
	 * @param predecessors
	 */
	private static void dfsVisit(int u, Map<Integer, List<Integer>> adj,
			boolean[] traversed, int[] distanceTo, int[] predecessors) {

		for (int v : adj.get(u)) {
			if (!traversed[v]) {
				predecessors[v] = u;
				distanceTo[predecessors[v]]++;
				dfsVisit(v, adj, traversed, distanceTo, predecessors);
			}
		}
		traversed[u] = true;
		// set timestamp
		// set predecessor
		// both optional
	}

	private static int dfsVisit(String u, Map<String, List<String>> adj,
			Map<String, Boolean> traversed, Map<String, Integer> distanceTo,
			Map<String, Boolean> grey, int sizeOfConnectedComponents) {

		grey.put(u, true);

		for (String v : adj.get(u)) {
			if (!traversed.get(v) && !grey.get(v)) {
				distanceTo.put(v, distanceTo.get(v) + 1);
				sizeOfConnectedComponents = dfsVisit(v, adj, traversed,
						distanceTo, grey, sizeOfConnectedComponents + 1);
			}
		}

		traversed.put(u, true);

		// return size of connected components
		return sizeOfConnectedComponents;
	}

	public static class PointVertex {
		private int x;
		private int y;
		private boolean traversed;

		public PointVertex() {
		}

		public PointVertex(int x, int y, boolean traversed) {
			super();
			this.x = x;
			this.y = y;
			this.traversed = traversed;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public boolean isTraversed() {
			return traversed;
		}

		public void setTraversed(boolean traversed) {
			this.traversed = traversed;
		}

	}
}
