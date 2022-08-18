package dfinity;

import lists.ListNode;
import trees.TreeNode;

import java.util.*;

/**
 * - Trees
 * - Stacks
 * - PriorityQueues
 * - HashMaps
 * - Arrays
 * - LinkedList
 * - DP few problems
 */
public class Recap {

    public static void main(String[] args) {
//        System.out.println(longestIncreasingSubsequence(new int[]{1, 2, -1, 4, -8, 8}));
        int[] test = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
//        mergeSort(test);
//        quickSort(test);
//        System.out.println(Arrays.toString(test));


    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap();
        prefixSum.put(0, 1);

        int runningSum = 0;
        int result = 0;

        for (int num : nums) {
            runningSum += num;
            if (prefixSum.containsKey(runningSum - k))
                result += prefixSum.get(runningSum - k);

            prefixSum.put(runningSum, 1);
        }

        return result;
    }

    /*
    1,2,3,4
    2nd is 2
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i <= n; i++) {
            b = b.next;
        }

        while (b != null) {
            b = b.next;
            a = a.next;
        }

        a.next = a.next.next;

        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            // save next
            next = current.next;

            // reverse
            current.next = previous;

            // advance previous and current
            previous = current;
            current = next;
        }

        return previous;
    }

    public int minDepth(TreeNode root) {
        if (root != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        return 0;
    }

    Map<Integer, Integer> inOrderValToIndex = new HashMap();
    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            inOrderValToIndex.put(inorder[i], i);

        return doBuildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder,
                                 int start,
                                 int end) {
        if (start <= end) {
            TreeNode root = new TreeNode(preorder[preOrderIndex++]);
            int inOrderIndex = inOrderValToIndex.get(root.val);
            root.left = doBuildTree(preorder, start, inOrderIndex - 1);
            root.right = doBuildTree(preorder, inOrderIndex + 1, end);
            return root;
        }
        return null;
    }

    private TreeNode nodeA = null;
    private TreeNode nodeB = null;
    private TreeNode previous = null;

    public void recoverTree(TreeNode root) {
        recover(root);

        // swap node values
        int tmp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = tmp;
    }

    private void recover(TreeNode root) {
        if (root != null) {

            recover(root.left);

            if (nodeA == null && previous != null && previous.val >= root.val) nodeA = previous;
            if (nodeA != null && previous != null && previous.val >= root.val) nodeB = previous;

            recover(root.right);
        }
    }

    static List<Integer> inOrderTraversal = new ArrayList();


    public static boolean isValidBST(TreeNode root) {
//        return doValidate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        for (int i = 1; i < inOrderTraversal.size(); i++)
            if (inOrderTraversal.get(i) <= inOrderTraversal.get(i)) return false;

        return true;
    }

    private static void collectNodesInOrder(TreeNode root) {
        if (root != null) {
            inOrderTraversal.add(root.val);
            collectNodesInOrder(root.left);
            collectNodesInOrder(root.right);
        }
    }

    private static boolean doValidate(TreeNode root,
                                      Long minValue,
                                      Long maxValue) {
        if (root == null) return true;
        if (root.val >= maxValue || root.val <= minValue) return false;
        return doValidate(root.left, minValue, Long.valueOf(root.val)) && doValidate(root.right, Long.valueOf(root.val), maxValue);
    }

    public List<TreeNode> generateTrees(int n) {
        return createAllTrees(1, n);
    }

    private static List<TreeNode> createAllTrees(int start, int end) {
        List<TreeNode> results = new ArrayList();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = createAllTrees(start, i - 1);
            List<TreeNode> rightTrees = createAllTrees(i + 1, end);
            for (TreeNode leftChild : leftTrees) {
                for (TreeNode rightChild : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftChild;
                    root.right = rightChild;
                    results.add(root);
                }
            }
        }

        return results;
    }


    public static void quickSort(int[] r) {
        doQuickSort(r, 0, r.length - 1);
    }

    private static void doQuickSort(int r[], int start, int end) {
        if (start < end) {
            int pivot = partition(r, start, end);
            doQuickSort(r, start, pivot);
            doQuickSort(r, pivot + 1, end);
        }
    }

    private static int partition(int[] r,
                                 int start,
                                 int end) {
        int i = start;
        int j = end + 1;

        while (true) {
            while (r[start] < r[--j]) if (j == start) break;
            while (r[start] >= r[++i]) if (i == end) break;
            if (i >= j) break;
            swap(r, i, j);
        }

        swap(r, start, j);
        return j;
    }

    private static void swap(int[] r,
                             int i,
                             int j) {
        int tmp = r[i];
        r[i] = r[j];
        r[j] = tmp;
    }

    static int[] aux;

    public static void mergeSort(int[] r) {
        aux = new int[r.length];
        doMergeSort(r, 0, r.length - 1);
    }

    private static void doMergeSort(int[] r,
                                    int start,
                                    int end) {
        if (start < end) { // check equality
            int middle = start + end >>> 1;
            doMergeSort(r, start, middle);
            doMergeSort(r, middle + 1, end);
            merge(r, start, middle, end);
        }
    }

    public static void merge(int[] r,
                             int start,
                             int middle,
                             int end) {
        for (int k = start; k <= end; k++)
            aux[k] = r[k];

        int i = start;
        int j = middle + 1;

        for (int k = start; k <= end; k++) {
            if (i > middle) r[k] = aux[j++];
            else if (j > end) r[k] = aux[i++];
            else if (aux[i] < aux[j]) r[k] = aux[i++];
            else r[k] = aux[j++];

        }


    }

    public static int longestPalindromicSubsequenceMemoization(String s) {
        char[] r = s.toCharArray();
        int[][] memo = new int[r.length][r.length];
        for (int[] m : memo)
            Arrays.fill(m, -1);
        return doFindLPSub(r, 0, r.length - 1, memo);
    }

    private static int doFindLPSub(char[] r,
                                   int start,
                                   int end,
                                   int[][] memo) {

        if (start > end) return 0;

        if (start == end) return 1;

        if (memo[start][end] == -1) {
            if (r[start] == r[end]) {
                memo[start][end] = 2 + doFindLPSub(r, start + 1, end - 1, memo);
            } else {
                memo[start][end] = Math.max(
                        1 + doFindLPSub(r, start, end - 1, memo),
                        1 + doFindLPSub(r, start + 1, end, memo)
                );
            }
        }

        return memo[start][end];

    }

    // bbab
    // argbbrza
    // awetrvbna => awa,aea,ata,ara,ava,aba,ana

    public static int longestPalindromicSubsequence(String s) {
        char[] r = s.toCharArray();
        int[][] dp = new int[r.length][r.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (r[i] == r[j])
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        // Find max
        return max;
    }

    // 1,2,-1,4,-8,8
    // 1,1, 1,1, 1,1
    // 1,
    public static int longestIncreasingSubsequence(int[] r) {
        int max = 0;
        int[] dp = new int[r.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (r[j] > r[i]) dp[j] = Math.max(dp[j], 1 + dp[i]);
                else dp[j] = dp[i];
            }
        }

        // Then find max
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int longestPalindromicString(String s) {
        int max = Integer.MIN_VALUE;

        // Find maximum for odd length strings
        for (int centroid = 0; centroid < s.length(); centroid++) {
            int expander = 0;
            while (centroid - expander >= 0 && centroid + expander < s.length() && s.charAt(centroid - expander) == s.charAt(centroid + expander)) {
                max = Math.max(max, centroid + expander - (centroid - expander));
                expander++;
            }
        }


        return max;
    }

    // 121
    public static boolean isPalindrome(int n) {
        int reversed = 0;
        int keeper = n;
        int remainder;
        while (n > 0) {
            remainder = n % 10; // 1, 2, 1
            reversed = reversed * 10 + remainder; // 0*10+1=1. 1*10+2 = 12, 12*10+1 = 121
            n /= 10; // 12, 1, 0
        }

        return reversed == keeper;
    }

    // 7 8 9 10 1 2 3
    public int searchInRotatedArray(int[] r, int ta) {
        // Find point of rotation
        int resultIndex = 0;
        int start = 0;
        int end = r.length - 1;
        while (start < end) {
            int middle = (start + end) >>> 1;
            if (r[middle] > r[end]) start = middle + 1;
            else start = middle;
        }

        return resultIndex;
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> levels = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = q.poll();
                level.add(currentNode.val);
                if (currentNode.left != null) q.offer(currentNode.left);
                if (currentNode.right != null) q.offer(currentNode.right);
            }

            levels.add(level);
        }
        return levels;
    }

    private int findNumberOfIslands(String[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals("1")) {
                    doFindIslands(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void doFindIslands(String grid[][], int i, int j) {
        if (!inBounds(grid, i, j)) return;

        if (grid[i][j].equals("0")) return;

        grid[i][j] = "0";
        doFindIslands(grid, i - 1, j);
        doFindIslands(grid, i, j + 1);
        doFindIslands(grid, i + 1, j);
        doFindIslands(grid, i, j - 1);

    }

    boolean inBounds(String grid[][], int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    public List<List<String>> groupAnagrams(String[] anagrams) {

        return null;
    }

    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left != right) {
            int height = Math.max(heights[left], heights[right]);
            int currentMaxArea = height * (right - left);
            max = Math.max(max, currentMaxArea);
            if (left >= right) right--;
            else left++;
        }
        return max;
    }
}
