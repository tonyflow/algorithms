package apple;

public class ShufflerTest {


    public static void main(String[] args) {
        System.out.printf("%.16s  %.16s \n", "Number of cards", "Number of rounds");
//        for (int i = 1; i <= 100; i++) {
////            System.out.println("Processing deck of " + i + " cards");
//            Shuffler shuffler = new Shuffler(i, false);
//            shuffler.shuffle();
////            System.out.println(shuffler.getOriginal());
////            System.out.println("Total number of rounds " + shuffler.getRounds() + " for " + i + " cards");
////            System.out.printf("%3d %17d\n", i, shuffler.getRounds());
//            System.out.printf("%d %16d\n", i, shuffler.getRounds());
//        }
        Shuffler shuffler = new Shuffler(5, false);
        System.out.println("Original deck " + shuffler.getOriginal());
        shuffler.shuffle();
        System.out.println("Total number of rounds " + shuffler.getRounds());

    }
}
