package apple;

import java.util.LinkedList;
import java.util.Queue;

public class Playground {

    public static void main(String[] args) {
        Queue<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        Queue<Integer> b = new LinkedList<>();
        b.add(1);
        b.add(3);
        b.add(2);

        Queue<Integer> c = new LinkedList<>();
        c.add(1);
        c.add(2);
        c.add(3);

        Queue<Integer> d = new LinkedList<>(a);

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
    }
}
