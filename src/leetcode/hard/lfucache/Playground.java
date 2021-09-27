package leetcode.hard.lfucache;

public class Playground {

    static class Test {
        int a;
        long b;

        public Test(int a, long b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return this.a;
        }

        public long getB() {
            return this.b;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        TreeMap<Integer, Integer> foo = new TreeMap();
//        foo.put(1, 3);
//        foo.put(4, 8);
//        foo.put(2, 8);
//        foo.put(32, 8);
//        foo.put(0, 8);
//        foo.put(-3, 8);
//        while (!foo.entrySet().isEmpty()) {
//            System.out.println(foo.pollFirstEntry());
//        }

//        TreeMap<Test,Integer> foo = new TreeMap(Comparator.comparingInt(Test::getA).thenComparingLong(Test::getB));
//        foo.put(new Test(1,2),1);
//        foo.put(new Test(3,4),1);
//        foo.put(new Test(5,6),1);
//        foo.put(new Test(7,8),1);
//        foo.put(new Test(9,10),1);
//        foo.put(new Test(9,12),1);
//
//        while(!foo.entrySet().isEmpty()){
//            System.out.println(foo.pollFirstEntry());
//        }

//        for (int i = 0; i < 100; i++) {
//            LFUCacheUsingTreeMap lfuCache = new LFUCacheUsingTreeMap(2);
            LFUCache lfuCache = new LFUCache(2);
            lfuCache.put(1, 1);
            lfuCache.put(2, 2);
            System.out.println(lfuCache.get(1));
            lfuCache.put(3, 3);
            System.out.println(lfuCache.get(2));
            System.out.println(lfuCache.get(3));
            lfuCache.put(4, 4);
            System.out.println(lfuCache.get(1));
            System.out.println(lfuCache.get(3));
            System.out.println(lfuCache.get(4));
            System.out.println("=====================================");
            Thread.sleep(1000l);
//        }
    }
}
