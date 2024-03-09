package februaryreset.ethonai;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Challenge {

    /**
     * - list of lists
     * - compute all of the combinations
     * specification=[[1, 2, 3], [4, 5]]
     * <p>
     * [[1, 4], [1, 5], [2, 4], ...[3, 5]]
     * <p>
     * spec=[[1, 2], [3, 4],  --> [5, 6, 7]]
     * <p>
     * [
     * [1, 3, 5], [1, 3, 6], [1, 3, 7],
     * [1, 4, 5], [1, 4, 6], [1, 4, 7],
     * [2, 3, 5], [2, 3, 6], [2, 3, 7],
     * [2, 4, 5], [2, 4, 6], [2, 4, 7]
     * <p>
     * ... [2, 4, 7]]
     * <p>
     * Housekeeping
     * - empty list of lists =>
     * - 1 list => return the list => [[1, 2, 3]] => [[1],[2],[3]]
     * - 2 lists => check specification
     * <p>
     * 1st level of recursion (remaining = initial, result=[])
     * [1,2,3]
     * [1,4]
     * recLevelResult = [1,4],[1,5],[2,4],[2,5],[3,4],[3,5]
     * <p>
     * 2nd level of recursion (remaining, partial)
     * what is the base level condition = (remaining = empty)
     */

    List<List<Integer>> find(int[][] r) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> partial = new Stack<>();
        doFind(r, 0, partial, result);
        return result;
    }

    private void doFind(
            int[][] r,
            int current,
            Stack<Integer> partial,
            List<List<Integer>> result
    ) {
        // Base case: There are no more arrays to be processed
        if (current == r.length) {
            result.add(new ArrayList<>(partial));
            return;
        }

        for (int i : r[current]) {
            partial.push(i);
            doFind(r, current + 1, partial, result);
            partial.pop();
        }
    }
}
