package leetcode;

import java.util.HashMap;

public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        HashMap<Character, Integer> balloonMap = new HashMap<>();
        for (char c : balloon.toCharArray()) {
            balloonMap.put(c, 0);
        }

        for (char c : text.toCharArray()) {
            if (balloonMap.containsKey(c)) {
                balloonMap.put(c, balloonMap.get(c) + 1);
            }
        }

        int numberOfBalloons = 0;
        while (true) {
            boolean canFormWord = true;
            for (char c : balloon.toCharArray()) {
                Integer letterCount = balloonMap.get(c);
                if (letterCount == 0) {
                    canFormWord = false;
                } else {
                    balloonMap.put(c, balloonMap.get(c) - 1);
                }
            }
            if (canFormWord) numberOfBalloons++;
            else {
                break;
            }
        }

        return numberOfBalloons;

    }
}
