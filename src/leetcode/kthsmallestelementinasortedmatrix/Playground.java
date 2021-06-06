package leetcode.kthsmallestelementinasortedmatrix;

public class Playground {

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix kthSmallestElementInASortedMatrix = new KthSmallestElementInASortedMatrix();
        int[][] test = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallestElementInASortedMatrix.kthSmallestBetter(test,8));
    }
}
