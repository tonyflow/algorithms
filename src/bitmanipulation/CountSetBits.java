package bitmanipulation;

public class CountSetBits {

    public static void main(String[] args) {
        int x = 13; //1 1 0 1
        int count = 0;
        while(x>0){
            count+=x&1;
            x>>=1;
        }

        System.out.println(count);
    }
}
