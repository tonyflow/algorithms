package search;

public class Playground {

    public static void main(String[] args) {

        int[] r = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch search = new BinarySearch();
        System.out.println(search.find(1, r));
        System.out.println(search.find(10, r));
        System.out.println(search.find(2, r));
        System.out.println(search.find(3, r));
        System.out.println(search.find(100, r));
        System.out.println(search.find(4, r));

        System.out.println();
        System.out.println();
        System.out.println();

        BinarySearch iterative = new BinarySearch();
        System.out.println(iterative.findIterative(r, 1));
        System.out.println(iterative.findIterative(r, 10));
        System.out.println(iterative.findIterative(r, 2));
        System.out.println(iterative.findIterative(r, 3));
        System.out.println(iterative.findIterative(r, 100));
        System.out.println(iterative.findIterative(r, 4));
    }
}
