package hackerrank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DynamicProgramming {

	/**
	 * Fibonacci Modified
	 */
	public static void fibonacciModified(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger A = s.nextBigDecimal().toBigInteger();
		BigInteger B = s.nextBigDecimal().toBigInteger();
		int N = s.nextInt();
		BigInteger C = BigInteger.ZERO;
		for (int i = 0; i < N - 2; i++) {
			C = B.pow(2).add(A);
			BigInteger tmp = B;
			A = B;
			B = C;

		}
		System.out.println(C);
		s.close();
	}

	/**
	 * The coin change problem. Tried using Kadane's algorithm for maximum sub
	 * array
	 */
	public static void coinChangeProblem(String[] args) {
		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {

			int N = s.nextInt();
			int M = s.nextInt();
			int[] coins = new int[M];
			for (int j = 0; j < M; j++) {
				coins[i] = s.nextInt();
			}
			Arrays.sort(coins);
			int maxBoxes = N / coins[0];

		}
		s.close();
	}

	/**
	 * Nikita and the game.
	 * 
	 * Failing test case : 4096 4096 1024 256 256 128 128 128 128 512 512 512
	 * 512 256 256 512 512 128 32 32 32 32 128 128 1024 1024 2048 512 512 1024
	 * 2048 2048 1024 512 512 2048 2048 2048 16384 16384 2048 256 128 128 512
	 * 256 256 512 2048 1024 1024 512 512 1024 1024 1024 2048 512 512 1024 4096
	 * 4096 4096 2048 2048 4096 2048 2048 2048 1024 512 256 16 16 32 64 128 2048
	 * 512 512 512 512 8192 8192 32768 32768 65536 16384 8192 4096 4096 16384
	 * 16384 32768 8192 8192 16384 65536 16384 16384 16384 8192 8192
	 * 
	 */
	static int SCORE = 0;

	public static void nikitaAndTheGame(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			int length = s.nextInt();
			int[] numbers = new int[length];
			SCORE = 0;
			int total = 0;
			for (int j = 0; j < length; j++) {
				numbers[j] = s.nextInt();
				total += numbers[j];
			}

			nikita(numbers, total);

			System.out.println(SCORE);

		}

		s.close();
	}

	private static void nikita(int[] numbers, int total) {

		int length = numbers.length;

		if (length == 1) {
			System.out.println("Pivot :: " + numbers[0]);

		}
		if (length > 1) {
			int subtotal = 0;
			Integer pivot = null;

			for (int k = 0; k < length; k++) {
				subtotal += numbers[k];
				total -= numbers[k];
				if (subtotal == total) {
					pivot = k;
					SCORE++;
					break;
				}
			}

			if (pivot != null) {
				System.out.println("Partitioning at :: " + pivot);

				if (pivot < length / 2) { // found pivot on first half = >
											// second half is bigger
					System.out.println("Length of partition :: "
							+ (length - (pivot + 1)));
					nikita(Arrays.copyOfRange(numbers, pivot + 1, length),
							subtotal);
				} else {
					System.out.println("Length of partition :: " + pivot);

					nikita(Arrays.copyOfRange(numbers, 0, pivot + 1), subtotal);
				}
			}

		}

	}

	/**
	 * Mandragora Forest: This is actually a greedy algorithm problem. Sort
	 * mandragoras' healths and choose the max of them to eat and then defeat
	 * (or vice versa)
	 */

	static List<Integer> healths = new ArrayList<Integer>();
	static List<Integer> xp = new ArrayList<Integer>(); // total amount of
														// experience points per
														// execution

	public static void mandragorasForest(String[] args) {

		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();

		int S = 1; // strength
		int P = 0; // experience points

		for (int i = 0; i < tc; i++) {

			int nom = s.nextInt();
			for (int j = 0; j < nom; j++) {

				healths.add(s.nextInt());

			}

			mandragora(P, S);
			Collections.sort(xp);
			System.out.println(xp.get(xp.size() - 1));
			xp = new ArrayList<Integer>();// empty list
		}

		s.close();

	}

	private static void mandragora(int p, int s) {

		if (!healths.isEmpty()) {

			// List<Integer> eat = new ArrayList<Integer>();
			// Collections.copy(healths, eat);
			// List<Integer> defeat = new ArrayList<Integer>();
			// Collections.copy(healths, defeat);

			Integer arbitrary = healths.get(0);
			healths.remove(0);

			// eat
			mandragora(p, s + 1);

			// defeat
			mandragora(p + (s * arbitrary), s);

		} else {
			xp.add(p);
		}

	}

	/**
	 * Candies
	 */
	static Integer numberOfCandies = 0;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		int[] ratings = new int[N];
		int[] count = new int[N];
		Arrays.fill(count, 1);

		for (int i = 0; i < N; i++) {

			ratings[i] = s.nextInt();
		}

		partitionCandies(ratings);

		System.out.println(numberOfCandies);

		s.close();
	}

	private static void partitionCandies(int[] ratings) {
	}

	//
	// if (high - low > 1) {
	// if (high - low == 1) { // array contains two elements
	//
	// int diff = ratings[0] - ratings[1];
	// if (diff > 0 || diff < 0) {
	// numberOfCandies += 3; // one for the lower rated student and
	// // one for the higher rated student
	// } else { // equal elements
	// numberOfCandies += 2; // one for each student with the same
	// // rating
	// }
	// } else {
	// int max = findFirstIncreasing(ratings);
	// int[] left = Arrays.copyOfRange(ratings, 0, max + 1);
	// int[] right = Arrays.copyOfRange(ratings, max + 1,
	// ratings.length);
	// partitionCandies(left);
	// partitionCandies(right);
	//
	// mergeCandies(left, right);
	// }
	// } else if (ratings.length == 1) {
	// numberOfCandies++;
	// }
	// }

	private static void mergeCandies(int[] left, int[] right) {

	}

	private static int findFirstIncreasing(int[] ratings) {
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				return i;
			}
		}
		return 0;
	}
}
