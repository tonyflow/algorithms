package leetcode.hard.FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> stoneToPossibleJumps = new HashMap();
        for (int i = 0; i < stones.length; i++)
            stoneToPossibleJumps.put(stones[i], new HashSet());
        Set<Integer> zero = new HashSet();
        zero.add(1);
        stoneToPossibleJumps.put(0, zero);

        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (Integer jump : stoneToPossibleJumps.get(stone)) {
                int reach = stone + jump;

                if (reach == stones[stones.length - 1])
                    return true;

                Set<Integer> possibleReaches = stoneToPossibleJumps.get(reach);
                if (possibleReaches != null) {
                    possibleReaches.add(jump + 1);
                    possibleReaches.add(jump);
                    if (jump - 1 > 0) possibleReaches.add(jump - 1);
                }
            }
        }

        return false;
    }

    public boolean tle(int[] stones) {
        Map<Integer, Integer> unitsToIndex = new HashMap();
        for (int i = 0; i < stones.length; i++)
            unitsToIndex.put(stones[i], i);

        if (unitsToIndex.containsKey(stones[1]))
            return cross(stones, 1, 1, unitsToIndex);
        else return false;
    }

    private boolean cross(int[] stones,
                          int index,
                          int lastJump,
                          Map<Integer, Integer> unitsToIndex) {
        if (index == stones.length - 1) return true;

        boolean optionOne = false;
        boolean optionTwo = false;
        boolean optionThree = false;
        if (unitsToIndex.containsKey(stones[index] + lastJump - 1) && unitsToIndex.get(stones[index] + lastJump - 1) > index) {
            optionOne = cross(stones, unitsToIndex.get(stones[index] + lastJump - 1), lastJump - 1, unitsToIndex);
        }

        if (unitsToIndex.containsKey(stones[index] + lastJump) && unitsToIndex.get(stones[index] + lastJump) > index) {
            optionTwo = cross(stones, unitsToIndex.get(stones[index] + lastJump), lastJump, unitsToIndex);
        }

        if (unitsToIndex.containsKey(stones[index] + lastJump + 1) && unitsToIndex.get(stones[index] + lastJump + 1) > index) {
            optionThree = cross(stones, unitsToIndex.get(stones[index] + lastJump + 1), lastJump + 1, unitsToIndex);
        }

        return optionOne || optionTwo || optionThree;
    }
}
