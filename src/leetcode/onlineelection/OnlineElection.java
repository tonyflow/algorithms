package leetcode.onlineelection;

import java.util.HashMap;
import java.util.Map;

public class OnlineElection {

    int[] times;
    Map<Integer, Integer> timesToLeader = new HashMap<>();

    public OnlineElection(int[] persons, int[] times) {
        Map<Integer, Integer> counts = new HashMap<>();
        this.times = times;
        int lead = 0;
        for (int i = 0; i < persons.length; i++) {
            counts.put(persons[i], counts.getOrDefault(persons[i], 0) + 1);
            if (i == 0 || counts.get(persons[i]) >= counts.get(lead)) {
                lead = persons[i];
            }
            timesToLeader.put(times[i], lead);
        }

    }

    public int q(int t) {

        int start = 0;
        int end = times.length - 1;
        while (start < end) {
            int middle = (start + end + 1) >>> 1;
            if (times[middle] <= t) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }

        return timesToLeader.get(times[start]);
    }
}
