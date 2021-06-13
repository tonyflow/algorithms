package leetcode;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        HashSet<String> unique = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String strippedFromDots = split[0].replaceAll("\\.", "");
            int plusIndex = strippedFromDots.indexOf("+");
            if (plusIndex != -1) {
                strippedFromDots = strippedFromDots.substring(0, plusIndex);
            }
            unique.add(new StringBuilder(strippedFromDots).append("@").append(split[1]).toString());
        }

        return unique.size();
    }

    public static void main(String[] args) {
        numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"});
    }
}
