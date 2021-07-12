package leetcode.ReconstructItinerary;

import java.util.Arrays;
import java.util.List;

public class Playground {

    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<List<String>> air = Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO"));
        List<String> itinerary = reconstructItinerary.findItinerary(air);
        for (String city : itinerary) {
            System.out.print(city + " ");
        }
    }
}
