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
        a.add(1);
        a.add(3);
        a.add(2);

        Queue<Integer> c = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        Queue<Integer> d = new LinkedList<>(a);

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
    }
}
