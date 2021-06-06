package trees;

public class Playground {

    public static void main(String[] args) {
        BinarySearchTree one = new BinarySearchTree();

        one.put(4);
        one.put(5);
        one.put(1);
        one.put(2);
        one.put(0);
        one.put(3);
        one.put(6);
        one.put(7);

//        System.out.println(one.height());

        BinarySearchTree two = new BinarySearchTree();

//        System.out.println(two.height());

        BinarySearchTree three = new BinarySearchTree();
        three.put(1);
        three.put(2);

//        System.out.println(three.height());

        BinarySearchTree four = new BinarySearchTree();
        four.put(1);

//        System.out.println(four.height());

//        Traversals.inOrder(one.root);
//        System.out.println("=================");
//        Traversals.preOrder(one.root);
//        System.out.println("=================");
//        Traversals.postOrder(one.root);
//
//        System.out.println("_______________________");

        // Binary tree
        TreeNode symmetric = new TreeNode(1);
        symmetric.right = new TreeNode(2);
        symmetric.left = new TreeNode(2);
        symmetric.right.right = new TreeNode(3);
        symmetric.right.left = new TreeNode(4);
        symmetric.left.left = new TreeNode(3);
        symmetric.left.right = new TreeNode(4);

        Traversals.inOrder(symmetric);
        System.out.println("==================");
        Traversals.postOrder(symmetric);

    }
}
