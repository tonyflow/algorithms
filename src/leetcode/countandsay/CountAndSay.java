package leetcode.countandsay;

public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        else return convert(countAndSay(n - 1));
    }

    private String convert(String n) {

        char current = n.charAt(0);
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == current) {
                count++;
            } else {
                builder.append(count + Character.toString(current));
                count = 1;
                current = n.charAt(i);
            }
        }
        builder.append(count + Character.toString(current));
        return builder.toString();
    }
}
