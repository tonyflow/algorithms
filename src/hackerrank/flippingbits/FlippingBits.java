package hackerrank.flippingbits;

public class FlippingBits {

    public long flippingBits(long n) {
        return Long.parseLong(Long
                .toBinaryString(~n).substring(32, 64), 2);
    }
}
