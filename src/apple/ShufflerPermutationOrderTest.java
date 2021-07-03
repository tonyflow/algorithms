package apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ShufflerPermutationOrderTest {

    static int CARDS = 313;

    public static void main(String[] args) {
        System.out.printf("%.16s  %.16s \n", "Number of cards", "Number of rounds");
        List<Long> times = new ArrayList<>();

        for (int i = 1; i <= CARDS; i++) {
            Shuffler shuffler = new Shuffler(i, false);
            Supplier<Integer> shufflerRun = () -> shuffler.order();
            ShufflerApp.Result result = ShufflerApp.time(shufflerRun);
            System.out.printf("%d %16d\n", i, result.rounds);
            times.add(result.time);
        }
        Long sum = times.stream().collect(Collectors.summingLong(Long::longValue));
        System.out.printf("Average computation time %1.5f ms\n", Double.valueOf(sum) / CARDS);
    }
}
