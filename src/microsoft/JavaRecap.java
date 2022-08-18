package microsoft;

import java.util.*;

public class JavaRecap {


    public static void main(String[] args) {

        Message message = new CarBuilder().setX(5).setY(5).build();

        List<Integer> foo = new ArrayList<>();
        Set<Integer> doubleBrace = new HashSet<Integer>() {
            {
                add(2);
                add(3);
            }
        };
        try {
            int number = Integer.parseInt("foo");
        } catch (UnsupportedOperationException uoe) {

        } catch (ArithmeticException ae) {

        } catch (Exception e) {

        } finally {
            //do sth
        }
    }
}

class A {
    public A() {

    }

    static void doA() {
        System.out.println("this is not right");
    }

    static void doA(int a) {
        System.out.println(a);
    }

    public void doC() {

    }
}

class B extends A {
    public B() {

    }

    @Override
    public void doC() {
        super.doC();
        System.out.println("Child c");
    }

}