package elastic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class OptimizeForReads {

    public static void main(String[] args) {
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentSkipListMap<Object, Object> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        ExecutorService executors = Executors.newFixedThreadPool(5);
        HashMap<String, Integer> map = new HashMap<>();

        IntStream.range(1, 5).forEach(n -> {
            Runnable writer = () -> map.put("entry" + n, n);
            executors.submit(writer);
        });


        AtomicReference<Map<String, Integer>> mapAtomicReference = new AtomicReference<>(map);
        Map<String, Integer> stringIntegerMap = mapAtomicReference.get();
        HashMap<String, Integer> updated = new HashMap<>();
        mapAtomicReference.set(updated);

        System.out.println("foo");
    }
}
