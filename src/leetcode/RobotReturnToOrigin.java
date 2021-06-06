package leetcode;

public class RobotReturnToOrigin {

    static boolean check(String moves){
        int[] directions = new int[]{0,0};
        for (char move : moves.toCharArray()) {
            if(move == 'U') directions[0]+=1;
            else if(move == 'D') directions[0]-=1;
            else if(move == 'L') directions[1]+=1;
            else if(move == 'R') directions[1]-=1;
            else throw new UnsupportedOperationException();

        }

        return directions[0]==0 && directions[1]==0;
    }

    public static void main(String[] args) {
        String moves = "UUDDLRLR";
        System.out.println(check(moves));
    }

}
