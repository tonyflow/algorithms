package leetcode.largestnumber;

import java.util.*;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        Map<Character, List<String>> helper = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            char firstDigit = String.valueOf(nums[i]).charAt(0);
            if (helper.containsKey(firstDigit)) {
                helper.get(firstDigit).add(String.valueOf(nums[i]));
            } else {
                List<String> partial = new ArrayList<>();
                partial.add(String.valueOf(nums[i]));
                helper.put(firstDigit, partial);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char i = '9'; i >= '0'; i--) {
            List<String> numbers = helper.get(i);
            if (numbers != null) {
                Collections.sort(numbers, (a, b) -> {
                            String order1 = a + b;
                            String order2 = b + a;
                            return -order1.compareTo(order2);
                        }
                );

                for (String number : numbers) {
                    result.append(number);
                }
            }
        }

        // There is the case where the number starts with zeros
        while (result.charAt(0)=='0' && result.length()>1)
            result.delete(0,0);
        return result.toString();
    }
}
