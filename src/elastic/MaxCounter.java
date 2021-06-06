package elastic;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class MaxCounter {

    // A tracker of the maximum score that has been seen so far
    public static class MaxScoreTracker {

        private int maxScore = Integer.MIN_VALUE;
        private AtomicReference<Integer> maxScoreReference = new AtomicReference<>(maxScore);
        private BlockingQueue<Integer> queue;
        private int BOUND;

        public MaxScoreTracker() {}


        public MaxScoreTracker(BlockingQueue<Integer> queue, int bound) {
            this.queue = queue;
            this.BOUND = bound;
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.submit(
                    () -> {
                        if (queue.size() > BOUND) {
                            while (!queue.isEmpty()) {
                                Integer update = queue.poll();
                                maxScoreReference.updateAndGet(current -> {
                                    if (current < update) {
                                        maxScoreReference.set(update);
                                    }
                                    return maxScoreReference.get();
                                });
                            }
                        }
                    },TimeUnit.HOURS
            );
        }

        // Get the current value of the maximum score
        public int getMaxScore() {
            return maxScoreReference.get();
        }

        // Update the maximum score if, and only if,
        // the given score is greater than the current maximum score
        public void updateMaxScoreIfNecessary(int score) {

        }
    }

    public static void main(String[] args) throws Exception {
        int numThreads = 4;
        int iters = 100;

        int res = test(numThreads, iters);
        System.out.println(res);
    }

    private static int test(int numThreads, int iters) throws Exception {
        Random random = new Random();
        int maxDelta = 0;
        for (int iter = 0; iter < iters; ++iter) {
            MaxScoreTracker maxScoreTracker = new MaxScoreTracker();
            Thread[] threads = new Thread[numThreads];
            int maxScore = Integer.MIN_VALUE;
            CountDownLatch startSignal = new CountDownLatch(1);
            for (int i = 0; i < numThreads; ++i) {
                final int score = random.nextInt();
                maxScore = Math.max(maxScore, score);
                threads[i] = new Thread(() -> {
                    try {
                        startSignal.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    maxScoreTracker.updateMaxScoreIfNecessary(score);
                });
                threads[i].start();
            }
            startSignal.countDown();
            for (Thread thread : threads) {
                thread.join();
            }
            System.out.println("maxScoreTracker " + maxScoreTracker.getMaxScore());
            System.out.println("maxScore " + maxScoreTracker.getMaxScore());
            System.out.println("maxDelta " + maxDelta);
            maxDelta = Math.max(maxDelta, Math.abs(maxScoreTracker.getMaxScore() - maxScore));
        }

        return maxDelta;
    }
}
