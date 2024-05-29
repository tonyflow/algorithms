package hackerrank;

import java.util.*;
import java.util.Map.Entry;

public class Sorting {

	/**
	 * Intro to tutorial challenges
	 * 
	 * @param args
	 */
	public static void introToSortingTutorialChallenges(String[] args) {

		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int n = s.nextInt();
		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = s.nextInt();
		}

		for (int i = 0; i < n; i++) {
			if (ar[i] == V) {
				System.out.println(i);
				break;
			}
		}

		s.close();

	}

	// ////// INSERTION SORT PART ONE /////////////////////////

	public static void insertionSort2Main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
			ar[i] = s.nextInt();
		}

		insertionSort(ar);

		s.close();

	}

	public static void insertIntoSorted(int[] ar) {
		int e = ar[ar.length - 1];
		int i = ar.length - 1;
		while (i > 0 && ar[i - 1] > e) {
			ar[i] = ar[i - 1];
			i--;
			printArray(ar);
		}
		ar[i] = e;
		printArray(ar);
	}

	public static int insertionSort(int[] r) {

		int sumOfSwaps = 0;
		for (int j = 1; j < r.length; j++) {
			int key = r[j];
			int i = j - 1;
			while (i >= 0 && r[i] > key) {
				int tmp = r[i + 1];
				r[i + 1] = r[i];
				r[i] = tmp;
				i--;
				sumOfSwaps++;
			}
			// printArray(r);
		}
		return sumOfSwaps;
	}

	/**
	 * Quicksort / partition. Pivot element is selected as the last one of the
	 * array given as input to quicksort (introduction to algorithgms - MIT).
	 * While, the first element of the array is selected by hacker rank hints.
	 * Optimized selection of the pivot element will result in smaller time
	 * complexities. (Binary search of array).
	 * 
	 * @param args
	 */
	public static void quickSortMain(String[] args) {

		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < l; i++) {
			A.add(s.nextInt());
		}
		quicksort(A);

		s.close();

	}

	private static int partition(List<Integer> A) {
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		int pivot = A.get(0);
		for (Integer i : A) {
			if (i < pivot) {
				left.add(i);
			} else if (i > pivot) {
				right.add(i);
			}
		}
		left.add(pivot);
		left.addAll(right);
		A.clear();
		A.addAll(left);
		return A.indexOf(pivot);

	}

	private static void quicksort(List<Integer> A) {

		if (A.size() > 1) {
			int q = partition(A);
			quicksort(A.subList(0, q)); // from is exclusive
			quicksort(A.subList(q + 1, A.size())); // from is exclusive
			printList(A);
		}

	}

	/**
	 * Quick sort in place using the Lomuto partitioning. This technique enables
	 * us to avoid using multiple sublists to store results. All swaps are
	 * performed in the same list/array while keeping track of desired indices.
	 * 
	 * We will be using as a pivot element, the last element of the array.
	 * 
	 * algorithm quicksort(A, lo, hi) is if lo < hi then p := partition(A, lo,
	 * hi) quicksort(A, lo, p – 1)
	 * 
	 * quicksort(A, p + 1, hi) algorithm partition(A, lo, hi) is pivot := A[hi]
	 * i := lo // place for swapping for j := lo to hi – 1 do if A[j] ≤ pivot
	 * then swap A[i] with A[j] i := i + 1 swap A[i] with A[hi] return i
	 * 
	 * https://en.wikipedia.org/wiki/Quicksort#Algorithm
	 * 
	 * @param args
	 */
	public static void quicksortInPlaceMain(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int[] A = new int[l];
		for (int i = 0; i < l; i++) {
			A[i] = s.nextInt();
		}
		quicksortInPlace(A, 0, l - 1);

		s.close();
	}

	private static LomutoPartitionResult lomutoPartitioning(int[] A, int lo,
			int hi) {

		int sumOfSwaps = 0;
		int pivot = A[hi];
		int i = lo;

		int tmp = 0;
		for (int j = lo; j <= hi - 1; j++) {
			if (A[j] <= pivot) {
				// swap A[i] with A[j]
				tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
				// increment i
				i++;
				sumOfSwaps++;
			}

		}
		tmp = A[i];
		A[i] = A[hi];
		A[hi] = tmp;
		sumOfSwaps++;

		// printArray(A);
		return new LomutoPartitionResult(sumOfSwaps, i);
	}

	private static int quicksortInPlace(int[] A, int lo, int hi) {

		int sumOfSwaps = 0;
		int leftSum = 0;
		int rightSum = 0;
		LomutoPartitionResult result = new LomutoPartitionResult();
		if (hi > lo) {
			result = lomutoPartitioning(A, lo, hi);
			leftSum = quicksortInPlace(A, lo, result.getP() - 1);
			rightSum = quicksortInPlace(A, result.getP() + 1, hi);
		}

		return sumOfSwaps += result.getSumOfSwaps() + rightSum + leftSum;
	}

	/**
	 * Bigger is greater. The following algorithm generates the next permutation
	 * lexicographically after a given permutation. It changes the given
	 * permutation in-place.
	 * 
	 * Find the largest index k such that a[k] < a[k + 1]. If no such index
	 * exists, the permutation is the last permutation. Find the largest index l
	 * greater than k such that a[k] < a[l]. Swap the value of a[k] with that of
	 * a[l]. Reverse the sequence from a[k + 1] up to and including the final
	 * element a[n].
	 * 
	 * Or
	 * 
	 * Identify longest non increasing suffix
	 * 
	 * @param args
	 */
	public static void nextPermutation(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		s.nextLine();
		for (int i = 0; i < tc; i++) {
			String w = s.nextLine();
			if (w.length() == 1) {
				System.out.println("no answer");
				continue;
			}
			char[] ca = w.toCharArray();
			int k = -1;

			// find k
			for (int j = ca.length - 2; j >= 0; j--) {
				if (ca[j] < ca[j + 1]) {
					k = j;
					break;
				}
			}

			if (k == -1) {
				System.out.println("no answer");
				continue;
			}

			// find l
			int l = 0;
			for (int j = ca.length - 1; j > k; j--) {
				if (ca[j] > ca[k]) {
					l = j;
					break;
				}
			}

			// swap ca[k],ca[l]
			char tmp = ca[k];
			ca[k] = ca[l];
			ca[l] = tmp;

			// sort sequence a[k+1] to a[ca.length-1]
			char[] sorted = new char[ca.length - k - 1];
			for (int j = k + 1, helper = 0; j < ca.length; j++, helper++) {
				sorted[helper] = ca[j];
			}
			Arrays.sort(sorted);
			for (int j = k + 1, helper = 0; j < ca.length; j++, helper++) {
				ca[j] = sorted[helper];
			}

			System.out.println(new String(ca));

		}
		s.close();
	}

	/**
	 * Running time of quicksort. Difference of shifts / swaps between quicksort
	 * and insertion sort.
	 * 
	 * @param args
	 */
	public static void runningTimeOfQuickSortInsertionSortComparisonMain(
			String[] args) {

		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		int[] A = new int[l];
		for (int i = 0; i < l; i++) {
			A[i] = s.nextInt();
		}
		int[] cloneOfA = A.clone();
		double insertionSortSumOfSwaps = insertionSort(A);
		double quicksortInPlaceSumOfSwaps = quicksortInPlace(cloneOfA, 0, l - 1);

		System.out.println(insertionSortSumOfSwaps);
		System.out.println(quicksortInPlaceSumOfSwaps);
		System.out.println(Double.valueOf(
				insertionSortSumOfSwaps - quicksortInPlaceSumOfSwaps)
				.intValue());
		s.close();

	}

	public static class LomutoPartitionResult {
		private int sumOfSwaps;
		private int p;

		public LomutoPartitionResult() {
			this.sumOfSwaps = 0;
			this.p = 0;
		}

		public LomutoPartitionResult(int sumOfSwaps, int p) {
			super();
			this.sumOfSwaps = sumOfSwaps;
			this.p = p;
		}

		public int getSumOfSwaps() {
			return sumOfSwaps;
		}

		public void setSumOfSwaps(int sumOfSwaps) {
			this.sumOfSwaps = sumOfSwaps;
		}

		public int getP() {
			return p;
		}

		public void setP(int p) {
			this.p = p;
		}

	}

	private static void printList(List<Integer> l) {
		for (Integer integer : l) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	/**
	 * Counting sort I
	 * 
	 * @param args
	 */
	public static void countingSortIMain(String[] args) {
		Scanner s = new Scanner(System.in);
		Map<Integer, Integer> occurences = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			occurences.put(i, 0);
		}

		int numbers = s.nextInt();
		for (int i = 0; i < numbers; i++) {
			int n = s.nextInt();
			occurences.put(n, occurences.get(n) + 1);
		}

		for (Map.Entry<Integer, Integer> occurence : occurences.entrySet()) {
			System.out.print(occurence.getValue() + " ");
		}
		s.close();
	}

	/**
	 * Counting Sort II
	 * 
	 * @param args
	 */
	public static void countingSortIIMain(String[] args) {
		Scanner s = new Scanner(System.in);
		int numbers = s.nextInt();
		int[] r = new int[numbers];

		for (int i = 0; i < numbers; i++) {
			r[i] = s.nextInt();
		}
		Arrays.sort(r);
		printArray(r);
		s.close();
	}

	/**
	 * Counting Sort 3
	 * 
	 * @param args
	 */
	public static void countingSortIIIMain(String[] args) {
		Scanner s = new Scanner(System.in);
		int lines = s.nextInt();
		int[] occurences = new int[100];
		Arrays.fill(occurences, 0);
		for (int i = 0; i < lines; i++) {
			occurences[s.nextInt()]++;
			s.nextLine();// actually read string
		}
		for (int i = 1; i < occurences.length; i++) {
			occurences[i] += occurences[i - 1];
		}
		printArray(occurences);
		s.close();
	}

	/**
	 * The full counting sort. Solution timed out on input bigger than 10^4
	 * 
	 * @param args
	 */
	public static void fullCountiSortSlow(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Map<Integer, List<String>> occurences = new TreeMap<>();
		for (int i = 0; i < 100; i++) {
			occurences.put(i, new ArrayList<>());
		}

		List<String> firstHalf = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int key = s.nextInt();
			String fragment = s.nextLine().trim();
			if (i < n / 2) {
				firstHalf.add(key + fragment + "_" + i);
			}
			occurences.get(key).add(fragment + "_" + i);
		}

		StringBuilder result = new StringBuilder();
		for (Entry<Integer, List<String>> occurence : occurences.entrySet()) {
			for (String word : occurence.getValue()) {
				if (!firstHalf.contains(occurence.getKey() + word)) {
					result.append(word.split("_")[0]).append(" ");
				} else {
					result.append("- ");
				}
			}
		}

		System.out.println(result.toString());
		s.close();
	}

	/**
	 * Full counting sort optimal
	 * 
	 */
	public static void fullCountingSortOptimal(String[] args) {

		long startOfTime = System.currentTimeMillis();

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		Map<Integer, List<String>> occurences = new TreeMap<>();
		for (int i = 0; i < 100; i++) {
			occurences.put(i, new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			int order = s.nextInt();
			if (i < n / 2) {
				s.nextLine(); // consume - ignore first half word
				occurences.get(order).add("- ");
			} else {
				occurences.get(order).add(s.nextLine().trim() + " ");
			}
		}

		StringBuilder result = new StringBuilder();
		for (Entry<Integer, List<String>> occurence : occurences.entrySet()) {
			for (String word : occurence.getValue()) {
				result.append(word);
			}
		}
		System.out.println(result);

		long endOfTime = System.currentTimeMillis();

		System.out.println(startOfTime);
		System.out.println(endOfTime);
		System.out.println("Took :: " + (endOfTime - startOfTime));

		s.close();
	}

	/**
	 * Closest numbers
	 * 
	 * @param args
	 */
	public static void closestNumbers(String[] args) {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = s.nextInt();
		}
		Arrays.sort(numbers);
		Map<Integer, Integer> AB = new TreeMap<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; i++) {
			int dif = Math.abs(Math.abs(numbers[i + 1]) - Math.abs(numbers[i]));
			// System.out.println(dif);
			if (dif < min) {
				min = dif;
				AB.clear();
				AB.put(numbers[i], numbers[i + 1]);
			} else if (dif == min) {
				AB.put(numbers[i], numbers[i + 1]);
			}
		}

		for (Map.Entry<Integer, Integer> i : AB.entrySet()) {
			System.out.print(i.getKey() + " " + i.getValue() + " ");
		}
		s.close();

	}

	/**
	 * Find the median. The linear time selection algorithm implementation
	 * This is a truely shitty implementation.
	 * @param args
	 */
	public static void findMedian(String[] args) {

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = s.nextInt();
		}

		Arrays.sort(numbers);
		System.out
				.println( numbers[numbers.length / 2]);
		s.close();
	}

}
