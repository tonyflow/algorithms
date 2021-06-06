package leetcode.allpossiblewordsinaphonenumber;

public class Playground {

    public static void main(String[] args) {
        AllPossibleWordsInAPhoneNumber allPossibleWordsInAPhoneNumber = new AllPossibleWordsInAPhoneNumber();
        allPossibleWordsInAPhoneNumber.find("2352").forEach(result -> System.out.println(result));

    }
}
