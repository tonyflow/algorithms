package leetcode.onlineelection;

public class Playground {

    public static void main(String[] args) {
        OnlineElection onlineElectionTimeLimitExceeded = new OnlineElection(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(onlineElectionTimeLimitExceeded.q(3));
        System.out.println(onlineElectionTimeLimitExceeded.q(12));
        System.out.println(onlineElectionTimeLimitExceeded.q(25));
        System.out.println(onlineElectionTimeLimitExceeded.q(15));
        System.out.println(onlineElectionTimeLimitExceeded.q(24));
        System.out.println(onlineElectionTimeLimitExceeded.q(8));
//        int[] candidates = {0, 1, 0, 2, 1, 3, 4, 3, 2, 4};
//        int[] times = {9, 14, 17, 25, 32, 66, 80, 82, 88, 99};
//        OnlineElectionTimeLimitExceeded onlineElectionTimeLimitExceeded = new OnlineElectionTimeLimitExceeded(candidates, times);
//        System.out.println(onlineElectionTimeLimitExceeded.q(98));

    }

//    ["TopVotedCandidate","q","q","q","q","q","q","q","q","q","q","q","q","q","q","q","q","q","q","q","q"]
//            [[[0,1,0,2,1,3,4,3,2,4],[9,14,17,25,32,66,80,82,88,99]],[66],[25],[98],[80],[10],[83],[26],[87],[15],[16],[9],[100],[81],[79],[81],[89],[13],[67],[33],[99]]
}
