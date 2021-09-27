package leetcode.hard.lfucache;

import java.util.LinkedHashSet;

public class DSPlayground {

    public static void main(String[] args) {
        LinkedHashSet<Integer> foo = new LinkedHashSet();
        foo.add(1);
        foo.add(2);
        foo.add(4);
        foo.add(0);
        foo.add(-1234);
        foo.remove(4);
        foo.remove(-1234);

        System.out.println(foo.iterator().next());
        System.out.println(foo.iterator().next());
        System.out.println(foo.iterator().next());
        System.out.println(foo.iterator().next());

    }
}
