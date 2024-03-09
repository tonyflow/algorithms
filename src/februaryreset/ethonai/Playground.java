package februaryreset.ethonai;

import java.util.ArrayList;
import java.util.List;

public class Playground {

    public static void main(String[] args) {
        Challenge challenge = new Challenge();
//        int[][] r = new int[][]{
//                new int[]{1, 2, 3},
//                new int[]{4, 5}
//        };
//
//        int[][] s = new int[][]{
//                new int[]{1, 2, 3}
//        };
//
//        List<List<Integer>> result = challenge.find(s);
//
//        for(List<Integer> partial: result)
//            System.out.println(partial);

        // [[1,4,5],[1,3,4],[2,6]]

        Node a = new Node(1);
        a.next = new Node(4);
        a.next.next = new Node(5);

        Node b = new Node(1);
        b.next = new Node(3);
        b.next.next = new Node(4);

        Node c = new Node(2);
        c.next = new Node(6);

        List<Node> heads = new ArrayList<>();
        heads.add(a);
        heads.add(b);
        heads.add(c);


        ChallengeII cha = new ChallengeII();
//        Node merged = cha.merge(heads);
        Node merged = cha.merge2(heads);

        while (merged != null) {
            System.out.println(merged.value);
            merged = merged.next;
        }

    }
}
