package algorithms.knuthmorrispratt;

public class Playground {

    public static void main(String[] args) {
        KnuthMorrisPratt knuthMorrisPratt = new KnuthMorrisPratt();
        System.out.println(knuthMorrisPratt.KMPExists("fdavsdvtarvgfgabc","abc"));
        System.out.println(knuthMorrisPratt.KMPIndex("fdavsdvtarvgfgabc","abc"));
        System.out.println(knuthMorrisPratt.KMPAllIndexes("fdabcvsdvtarvgfgabc","abc"));
        System.out.println(knuthMorrisPratt.KMPExists("fdavsdvtarvgfgabc","xxx"));

//        System.out.println(knuthMorrisPratt.naive("fdavsdvtarvgfgabc","abc"));
//        System.out.println(knuthMorrisPratt.naive("fdaabcvsdvtarvgfg","abc"));
//        System.out.println(knuthMorrisPratt.naive("fdavsdvtarvgfgabc","czc"));

    }
}
