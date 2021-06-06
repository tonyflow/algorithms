package leetcode.onlineelection;

import java.util.Arrays;

public class OnlineElectionTimeLimitExceeded {

    class Vote {
        int count;
        int lastUpdated;

        public Vote(int count,
                    int lastUpdated) {
            this.count = count;
            this.lastUpdated = lastUpdated;
        }
    }

    Vote[][] candidateVotesPerTimes;
    int[] times;
    int[] persons;

    public OnlineElectionTimeLimitExceeded(int[] persons, int[] times) {
        this.times = times;
        this.persons = persons;

        candidateVotesPerTimes = new Vote[persons.length][persons.length];

        for (Vote[] candidateVotesPerTime : candidateVotesPerTimes) {
            Arrays.fill(candidateVotesPerTime, new Vote(0, 0));
        }

        for (int i = 0; i < persons.length; i++) {
            Arrays.fill(
                    candidateVotesPerTimes[persons[i]],
                    i,
                    persons.length, i - 1 < 0 ?
                            new Vote(1, i) : new Vote(candidateVotesPerTimes[persons[i]][i - 1].count + 1, i));
        }
    }

    public int q(int t) {
        // Find the times interval - Use BS here!
        int start = 0;
        int end = times.length - 1;

        while (start < end) {
            int middle = (start + end + 1) >>> 1;
            if (times[middle] <= t) {
                start = middle;
            } else {
                end = middle - 1;
            }
        }

        int maxVotes = Integer.MIN_VALUE;
        int maxVotesLastUpdate = 0;
        int leadingCandidate = 0;

        // Time complexity here is linear
        for (int row = 0; row < candidateVotesPerTimes.length; row++) {
            if (candidateVotesPerTimes[row][start].count > maxVotes) {
                leadingCandidate = row;
                maxVotes = candidateVotesPerTimes[row][start].count;
                maxVotesLastUpdate = candidateVotesPerTimes[row][start].lastUpdated;
            } else if (candidateVotesPerTimes[row][start].count == maxVotes) {
                // The most recent vote belongs to the candidate represented by row. So update leading candidate
                if (candidateVotesPerTimes[row][start].lastUpdated > maxVotesLastUpdate) {
                    leadingCandidate = row;
                    maxVotesLastUpdate = candidateVotesPerTimes[row][start].lastUpdated;
                }
            }
        }

        return leadingCandidate;
    }
}
