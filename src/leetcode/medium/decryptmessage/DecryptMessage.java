package leetcode.medium.decryptmessage;

public class DecryptMessage {

    String decrypt(String word) {
        char[] r = word.toCharArray();

        StringBuilder builder = new StringBuilder();
        int helper = 1;
        for (int i = 0; i < r.length; i++) {
            // ascii value
            // val=d=100
            // val = n = 110
            // val = o = 111
            int val = r[i];

            // subtract the previous letter
            // val = 100-0 = 100
            // val = 110-99 = 11
            // val= 111-114 = -3
            val -= helper;

            // make it fit in the range
            //
            while (val < 'a' || val > 'z')
                // 26+26+26+11 = 89 + 26
                //
                val += 26;

            // subtract one
            // val = 99
            // val = 115-114
            // val 101 -1 = 100
            // val-=1;

            // find the final result
            // c
            // r
            //
            char endDecryptedChar = (char) val;
            builder.append(endDecryptedChar);

            // update helper
            // helper = 99
            // helper = 114
            helper += val;
        }

        return builder.toString();
    }
}
