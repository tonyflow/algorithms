package leetcode.hard.substringwithconcatenationofallwords;

public class Playground {

    public static void main(String[] args) {
        String s = "helloasdfasdfahelloasdfasdfafhelloasdfcarhellofasdfahello";
        int lastIndex = 0;
        int total = 0;
        while (lastIndex != -1) {
            lastIndex = s.indexOf("hello", lastIndex);
            if (lastIndex != -1) {
                total++;
                lastIndex += "hello".length();
            }
        }

        System.out.println(total);
    }
}
