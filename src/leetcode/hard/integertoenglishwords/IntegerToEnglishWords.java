package leetcode.hard.integertoenglishwords;

public class IntegerToEnglishWords {

    String[] tens = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] aboveTen = {"foo", "bar", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] magnitudes = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {

        if(num==0) return tens[num];

        StringBuilder builder = new StringBuilder();
        traverse(num, 0, builder);
        return builder.toString().replace("  "," ").trim();
    }

    private void traverse(int num,
                          int magnitude,
                          StringBuilder builder) {

        if (num == 0) return;

        // Process last two digits
        int remainder = num % 100;

        if(remainder!=0){
            builder.insert(0, magnitudes[magnitude]);
            builder.insert(0, " ");
        }

        if (remainder < 20 && remainder != 0) {
            builder.insert(0, tens[remainder]);
            num /= 100;
        } else {
            if (num % 10 != 0)
                builder.insert(0, tens[num % 10]);
            num /= 10;
            if (num % 10 != 0) {
                builder.insert(0, " ");
                builder.insert(0, aboveTen[num % 10]);
            }
            num /= 10;
        }
        builder.insert(0, " ");

        if (num % 10 != 0) {
            builder.insert(0, "Hundred");
            builder.insert(0, " ");
            builder.insert(0, tens[num % 10]);
            builder.insert(0, " ");
        }
        num /= 10;
        traverse(num, magnitude + 1, builder);
    }

    public String bar(int num) {

        StringBuilder builder = new StringBuilder();

        // Process last two digits
        int remainder = num % 100;
        if (remainder < 20 && remainder != 0) {
            builder.append(tens[remainder]);
            num /= 100;
        } else {
            if (num % 10 != 0)
                builder.insert(0, tens[num % 10]);
            num /= 10;
            if (num % 10 != 0) {
                builder.insert(0, " ");
                builder.insert(0, aboveTen[num % 10]);
            }
            num /= 10;
        }
        // At this point we have process 0-9 and 10-99 magnitude
        // The following loop is for processing the rest
        int magnitude = 0;
        while (num != 0) {
            remainder = num % 10;
            if (remainder != 0) {
                builder.insert(0, " ");
                builder.insert(0, magnitudes[magnitude - 1]);
                builder.insert(0, " ");
                builder.insert(0, tens[remainder]);
            }
            magnitude++;
            num /= 10;
        }

        return builder.toString();
    }
}
