package leetcode;

import trees.NaryNode;

public class NaryTreePostOrderTraversal {
    /**
     * Preorder
     * - root
     * - left
     * - right
     *
     * Post order
     * - left
     * - right
     * - root
     *
     * In order
     * - left
     * - root
     * - right
     *
     *
     */
    void traverse(NaryNode root){
        if(root == null) return;
        for (int i = 0; i < root.children.length; i++) {
            traverse(root.children[i]);
        }
        System.out.println(root.value);
    }
}
