package leetcode.univaluedbst;

import trees.TreeNode;

public class Playground {

    public static void main(String[] args) {
        UnivaluedBT univaluedBT = new UnivaluedBT();
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(1);
        head.left = new TreeNode(1);

        System.out.println(univaluedBT.check(head));
    }
}
