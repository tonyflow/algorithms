package leetcode.houserobberiii;

import trees.TreeNode;

import java.util.Objects;

public class Playground {

    static class Foo {
        TreeNode x;
        boolean include;

        public Foo(TreeNode x, boolean include) {
            this.x = x;
            this.include = include;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Foo foo = (Foo) o;
            return include == foo.include && Objects.equals(x, foo.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, include);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        Foo pair = new Foo(treeNode, false);
        Foo other = new Foo(treeNode, false);
        System.out.println(pair.equals(other));
    }
}
