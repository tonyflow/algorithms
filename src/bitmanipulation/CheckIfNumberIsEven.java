package bitmanipulation;

public class CheckIfNumberIsEven {

    static boolean check(int num) {
        return (num & 1) == 0;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 33; i += 2)
            System.out.println(i + " is even " + check(i));

        for (int i = 2; i < 33; i += 2)
            System.out.println(i + " is even " + check(i));
    }
}
