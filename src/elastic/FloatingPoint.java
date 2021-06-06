package elastic;

public class FloatingPoint {

    public static void main(String[] args) {
        float a = 1f;
        float b = 0.00000000001f;
        float d = 0.00000000000001f;
        float e = 0.0000000000000001f;
        float c = 0.0001f;
        System.out.println((a + b));
        System.out.println((c + b));
        System.out.println(a==(a + e));
        System.out.println(c==(c + b));
    }
}
