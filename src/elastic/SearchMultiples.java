package elastic;

public class SearchMultiples {

    static int elastic_searchMultiples(long[] numbers) {
        if (numbers == null) return 0;
        if (numbers.length == 0) return 0;

        int total = 0;

        // The max element in the array is less than 1000000
        // Since it's sorted then all elements in the array are less than 1000000
        // We only have to count zeroes and exit
        if (numbers[numbers.length - 1] < 1000000) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) total++;
            }
            return total;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 1000000 == 0) total++;
        }

        return total;
    }

    public static void main(String[] args) {
        elastic_searchMultiples(new long[]{0, 1000000, 1000000, 1000001, 1003299});
    }


}
