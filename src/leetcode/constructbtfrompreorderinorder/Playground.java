package leetcode.constructbtfrompreorderinorder;

public class Playground {

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
//        constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[]{3, 9, 1, 2, 20, 15, 7}, new int[]{1, 9, 2, 3, 15, 20, 7});
        constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(new int[]{1, 2}, new int[]{1, 2});
    }
}
