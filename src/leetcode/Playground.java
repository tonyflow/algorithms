package leetcode;

import leetcode.sumofleftleaves.SumOfLeftLeaves;
import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
//        UniquePaths uniquePaths = new UniquePaths();
//
//        int unique = uniquePaths.find(3, 2);
//        System.out.println(unique);

//        FirstLastOccurence firstLastOccurence = new FirstLastOccurence();
//        int[] results = firstLastOccurence.findLinear(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        int[] resultsLog = firstLastOccurence.findLogarithmic(new int[]{5, 7, 7, 8,8,8, 8, 10}, 8);
//
//        System.out.println(Arrays.toString(results));
//        System.out.println(Arrays.toString(resultsLog));

        char[][] board = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
//        WordSearchIn2DArray wordSearchIn2DArray = new WordSearchIn2DArray();
//        System.out.println(wordSearchIn2DArray.exist(board, "abcced"));
//        System.out.println(wordSearchIn2DArray.exist(board, "asa"));
//        System.out.println(wordSearchIn2DArray.exist(board, "bbb"));
//        System.out.println(wordSearchIn2DArray.exist(board, "abceseedas"));

        int[][] world = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1}
        };
//        NumberOfIslands numberOfIslands = new NumberOfIslands();
//        System.out.println(numberOfIslands.find(world));

//        SymmetricTree symmetricTree = new SymmetricTree();
//        // Binary symmetric tree
//        Node symmetric = new Node(1);
//        symmetric.right = new Node(2);
//        symmetric.left = new Node(2);
//        symmetric.right.right = new Node(3);
//        symmetric.right.left = new Node(4);
//        symmetric.left.left = new Node(3);
//        symmetric.left.right = new Node(4);
//
//        System.out.println(symmetricTree.check(symmetric));

        TreeNode leftmost = new TreeNode(1);

        leftmost.right = new TreeNode(3);
        leftmost.right.right = new TreeNode(6);
        leftmost.right.left = new TreeNode(5);
        leftmost.right.left.left = new TreeNode(7);

        leftmost.left = new TreeNode(2);
        leftmost.left.left = new TreeNode(4);

//        Node.printLeaves(leftmost);

//        FindBottomLeftSubtree findBottomLeftSubtree = new FindBottomLeftSubtree();
//        System.out.println(findBottomLeftSubtree.find(leftmost));

//        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
//        levelOrderTraversal.traverse(leftmost);

//        MaximumBinaryTreeWidth maximumBinaryTreeWidth = new MaximumBinaryTreeWidth();
//        System.out.println(maximumBinaryTreeWidth.getMax(leftmost));

//        Node toBeFlattened = new Node(1);
//        toBeFlattened.left = new Node(2);
//        toBeFlattened.left.left = new Node(3);
//        toBeFlattened.left.right = new Node(4);
//        toBeFlattened.right = new Node(5);
//        toBeFlattened.right.right = new Node(6);
//
//        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
//        flattenBinaryTree.flatten(toBeFlattened);

//        Node rightProjection = new Node(1);
//        rightProjection.right = new Node(5);
//        rightProjection.right.right = new Node(6);
//        rightProjection.left = new Node(2);
//        rightProjection.left.right = new Node(4);
//        rightProjection.left.right.right = new Node(8);
//
//
//        BinaryTreeRightProjection binaryTreeRightProjection = new BinaryTreeRightProjection();
//
//        System.out.println(binaryTreeRightProjection.project(rightProjection));

        TreeNode sumOfLeftLeaves = new TreeNode(3);
        sumOfLeftLeaves.right = new TreeNode(20);
        sumOfLeftLeaves.right.right = new TreeNode(7);
        sumOfLeftLeaves.right.left = new TreeNode(15);
        sumOfLeftLeaves.left = new TreeNode(9);

        SumOfLeftLeaves sumOfLeftLeavesAlgo = new SumOfLeftLeaves();
        System.out.println(sumOfLeftLeavesAlgo.find(sumOfLeftLeaves));

    }
}
