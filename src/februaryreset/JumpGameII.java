package februaryreset;

public class JumpGameII {

    int find(int[] r) {
        return doj(r, 0);
    }

    private int doj(int[] r, int index) {
        if (index == r.length - 1) return 0;
        if (index >= r.length) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= r[index]; i++) {
            min = Math.min(min, doj(r, index + i) + 1);
        }

        return min;
    }
}
