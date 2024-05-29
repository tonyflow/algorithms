package hackerrank;

import java.util.*;
import java.util.concurrent.Callable;

public class Implementation {


    public static void grades(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }


        for (int g: grades) {
            int nextMultipleOfFive=(g/5)*5+5;
            if (g<38 || nextMultipleOfFive-g>=3) {
                System.out.println(g);

            }else {
                System.out.println(nextMultipleOfFive);
            }
        }
    }

    public static void applesAndOranges(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();

        int applesInRange=0;
        int orangesInRange=0;

        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = a+in.nextInt();
            if(apple[apple_i]>=s && apple[apple_i]<=t){
                applesInRange++;
            }
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = b+in.nextInt();
            if(orange[orange_i] >=s && orange[orange_i] <=t){
                orangesInRange++;
            }
        }

        System.out.println(applesInRange);
        System.out.println(orangesInRange);
    }

    /**
     * Encryption
     */
    public static void encryption(String[] args) {

        Scanner s = new Scanner(System.in);
        String l = s.nextLine();

        char[] chars = l.toCharArray();

        int r= (int) Math.floor(Math.sqrt(l.length()));
        int c= (int) Math.ceil(Math.sqrt(l.length()));

        if (r*c<chars.length){
            r++;
        }

        char[][] grid =new char[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(grid[i],' ');
        }


        for (int i = 0, j = 0, k = 0; i < chars.length; i++) {
            grid[j][k]=chars[i];
            k++;
            if (k==c){ k=0; j++;}
        }

        for (int k = 0; k < c; k++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < r; j++) {
                if(grid[j][k]!=' '){
                    builder.append(grid[j][k]);
                }

            }
            builder.append(' ');
            System.out.print(builder.toString());
        }
    }
}
