package bitmanipulation;

public class ToggleCase {

    /*
    Uppercase to lowercase and vice versa
     */
    public static void main(String[] args) {
        char[] test = "thisisjustanEXAMPLE".toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < test.length; i++) {
            test[i]^=32;
        }
        System.out.println(new String(test));
    }
}
