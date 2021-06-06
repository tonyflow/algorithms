package leetcode.checkarrayformationthroughconcatenation;

import java.util.*;
import java.util.stream.Collectors;

public class CheckArrayFormationThroughConcatenation {

    class CoordinatePiece {
        int arrIndex;
        int x;
        int y;

        public CoordinatePiece(int arrIndex,
                               int x,
                               int y) {
            this.arrIndex = arrIndex;
            this.x = x;
            this.y = y;
        }

        int getArrIndex() {
            return this.arrIndex;
        }

        int getX() {
            return this.x;
        }

    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> firstPieceToIndex = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            firstPieceToIndex.put(pieces[i][0], i);
        }

        int current = 0;
        while (current < arr.length) {
            if (!firstPieceToIndex.containsKey(arr[current])) return false;
            Integer index = firstPieceToIndex.get(arr[current]);
            for (int j = 0; j < pieces[index].length && current < arr.length; j++, current++) {
                if (arr[current] != pieces[index][j]) return false;
            }
        }
        return true;
    }

}
