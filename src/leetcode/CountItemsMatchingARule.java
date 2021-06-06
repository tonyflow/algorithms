package leetcode;

import java.util.List;

public class CountItemsMatchingARule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        return Math.toIntExact(items.stream().filter(description -> (ruleKey.equals("type") && description.get(0).equals(ruleValue)) ||
                (ruleKey.equals("color") && description.get(1).equals(ruleValue)) ||
                (ruleKey.equals("name") && description.get(2).equals(ruleValue))).count());

    }
}
