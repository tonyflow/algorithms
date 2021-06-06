package leetcode.generateparentheses;

public class Playground {

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        int count = 0;
        for (String form : generateParentheses.generateParenthesis(8)) {
            System.out.println(count + " " + form);
            count++;
        }
    }
}
