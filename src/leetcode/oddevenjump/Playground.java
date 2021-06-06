package leetcode.oddevenjump;

public class Playground {

    public static void main(String[] args) {
//        OddEvenJump oddEvenJump = new OddEvenJump();
//        System.out.println(oddEvenJump.jumps(new int[]{10, 13, 12, 14, 15}));
//        System.out.println(oddEvenJump.jumps(new int[]{5, 1, 3, 4, 2}));

//        OddEvenJumpDeadEnd oddEvenJumpDeadEnd = new OddEvenJumpDeadEnd();
//        System.out.println(oddEvenJumpOptimised.jumps(new int[]{10, 13, 12, 12, 12, 14, 15}));
//        System.out.println(oddEvenJumpDeadEnd.jumps(new int[]{10, 13, 12, 14, 15}));
//        System.out.println(oddEvenJumpOptimised.jumps(new int[]{5, 1, 3, 4, 2}));

        OddEvenJumpOptimal oddEvenJumpOptimal = new OddEvenJumpOptimal();
        System.out.println(oddEvenJumpOptimal.jump(new int[]{5, 1, 3, 4, 2}));
    }
}
