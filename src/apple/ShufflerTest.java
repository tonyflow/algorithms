package apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShufflerTest {


    public static void main(String[] args) {
        System.out.printf("%.16s  %.16s \n", "Number of cards", "Number of rounds");
        List<Long> times = new ArrayList<>();
        for (int i = 313; i <= 1100; i+=100) {
            long start = System.currentTimeMillis();
            Shuffler shuffler = new Shuffler(i, false);
            System.out.printf("%d %16d\n", i, shuffler.order());
//            System.out.printf("%d %16d\n", i, shuffler.simulate());
            long end = System.currentTimeMillis();
            times.add(end - start);
        }

        System.out.println("Average time elapsed per number of cards " + times.stream().mapToLong(i -> i).sum() / 310);


        ////////////////////////////////////////////////////////////


//        long start = System.currentTimeMillis();
//        Shuffler shuffler = new Shuffler(300, false);
////        System.out.printf("%d %16d\n", 313, shuffler.order());
////        System.out.printf("%d %16d\n", 52, shuffler.simulate());
////        System.out.printf("%d %16d\n", 300, shuffler.order());
//
//
//        List<Integer> collect = IntStream.range(1, 313).mapToObj(i -> i).collect(Collectors.toList());
//        int counter = 0;
//        for (int i = 0; i < 1575169365; i++) {
//            Collections.shuffle(collect);
//        }
//        System.out.println(collect);
//
//
//        long end = System.currentTimeMillis();
//        System.out.println("Time elapsed " + (end - start));


    }
}
