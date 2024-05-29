package sorts;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/*
 * A heap is an array object with two major attributes: 
 * (1)A.length which represents the number of elements included in the array
 * (2)A.heap-size which represents how many elements in the heap are stored in the array
 * Worst case = Average = Best = O(nlogn)
 */
public class HeapSort {

	private static Integer HEAP_SIZE = null;

	public static void main(String[] args) {

		StopWatch timer = new StopWatch();
		timer.start();

		int[] A = new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };

		System.out.println("Arrays before heap sort takes action : "
				+ Arrays.toString(A));

		heapSort(A);

		timer.stop();
		System.out.println("Sort took : " + timer.getNanoTime()
				/ Math.pow(10, 9));
		System.out.println("Arrays after heap sort : " + Arrays.toString(A));

	}

	private static void heapSort(int[] A) {

		HEAP_SIZE = A.length;

		// build max heap
		buildMaxHeap(A);
		for (int i = A.length - 1; i > 0; i--) {

			// exchange A[i] with A[0]
			int tmp = A[0];
			A[0] = A[i];
			A[i] = tmp;

			// decrease size of heap by one.
			HEAP_SIZE--;
			// traverse heap to apply max heap property (maxHeapify())
			maxHeapify(A, 0);
		}
	}

	/**
	 * Procedure which guarantees the max-heap property. The running time of
	 * MAX-HEAPIFY on a subtree of size n rooted at a given node i is the
	 * THETA(1) time to fix up the relationships among the elements A[left(1)]
	 * and A[right(i)] plus the time to run MAX-HEAPIFY on a subtree rooted at
	 * one of the children of node i (assuming that the recursive call occurs).
	 * The children’s subtrees each have size at most 2n/3 — the worst case
	 * occurs when the bottom level of the tree is exactly half full—and
	 * therefore we can describe the running time of MAX-HEAPIFY by the
	 * recurrence. T(n)<=T(2n/3)+THETA(1) which results to T(n) = O(logn)
	 * (Master theorem).
	 */
	private static void maxHeapify(int[] A, int i) {

		// taking care of edge cases
		int left = left(i) == HEAP_SIZE ? left(i) - 1 : left(i);
		int right = right(i) == HEAP_SIZE ? right(i) - 1 : right(i);
		int largest = 0;

		if (left <= HEAP_SIZE && A[left] > A[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= HEAP_SIZE && A[right] > A[largest]) {
			largest = right;
		}

		if (largest != i) {
			// swap i and largest
			int tmp = A[i];
			A[i] = A[largest];
			A[largest] = tmp;
			maxHeapify(A, largest);
		}

	}

	/**
	 * The elements in the sub-array A[floor(n/2) + 1 : n]􏰀 are all leaves of
	 * the tree, and so each is a 1-element heap to begin with. The procedure
	 * BUILD-MAX-HEAP goes through the remaining nodes of the tree (n/2 to 1 :
	 * which are actually all heap parents - nodes from which minified heaps
	 * start) and runs MAX-HEAPIFY on each one.
	 */
	private static void buildMaxHeap(int[] A) {

		for (int i = A.length / 2; i >= 0; i--) {
			maxHeapify(A, i);
		}

	}

	private static int parent(int i) {
		return (int) Math.floor(i / 2);
	}

	private static int left(int i) {
		return 2 * i;
	}

	private static int right(int i) {
		return 2 * i + 1;
	}

	/**
	 * Verify maxHeapify behavior
	 * 
	 * @param args
	 */
	public static void _main(String[] args) {
		int[] A = new int[] { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1 };

		HEAP_SIZE = A.length;
		System.out.println("Arrays before max heapify takes action : "
				+ Arrays.toString(A));

		maxHeapify(A, 1);

		System.out.println("Result after max heapify is : "
				+ Arrays.toString(A));
	}

	/*
	 * Verify build max heap behavior
	 */
	public static void __main(String[] args) {
		int[] A = new int[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };

		HEAP_SIZE = A.length;
		System.out.println("Array before build max heap takes action : "
				+ Arrays.toString(A));

		buildMaxHeap(A);

		System.out.println("Result after build max heap is : "
				+ Arrays.toString(A));
	}

}
