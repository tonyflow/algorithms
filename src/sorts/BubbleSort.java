package sorts;

import java.util.Arrays;

/**
 * Algorithm passes through the list repeatedly, compares adjacent elements
 * swaps them if they are in the wrong order. By doing so it creates two areas :
 * a sorted and an unsorted one. The algorithm sorts elements in place making
 * its space complexity O(1).
 * 
 * Best: O(n) //sorted array Average : O(n) Worst: O(n^2) //
 * 
 * @author niko.strongioglou
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		// int[] r = new int[] { 3, 8, 5, 2, 7 };
		int[] r = new int[] { 6, 5, 4, 3, 2, 1 };
		bubbleSort(r);
		System.out.println("Sorted : " + Arrays.toString(r));
	}

	private static void bubbleSort(int[] r) {

		for (int i = 0; i < r.length; i++) {
			for (int j = 1; j < (r.length - i); j++) {
				if (r[j - 1] > r[j]) { // swap on condition match
					int tmp = r[j - 1];
					r[j - 1] = r[j];
					r[j] = tmp;
					System.out.println(Arrays.toString(r));
				}
			}
		}

	}
}
