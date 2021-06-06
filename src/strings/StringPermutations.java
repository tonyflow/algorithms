package strings;

public class StringPermutations {

    public void find(String s) {
        doFind(s, "");
    }

    private void doFind(String s, String sub) {

        if (s.isEmpty()) System.out.println(sub);

        for (char c : s.toCharArray()) {
            doFind(
                    s.substring(0, s.indexOf(c)) + s.substring(s.indexOf(c) + 1),
                    sub + c
            );
        }
    }
}
