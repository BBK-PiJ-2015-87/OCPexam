package searching;

/**
 * Created by vladimirsivanovs on 13/06/2016.
 */
public class StringParsing {
    public static void main(String[] args) {
        String num = String.valueOf(10);
        String dbl = String.valueOf(10.0);

        int i = Integer.parseInt("100");
        int i2 = Integer.parseInt("111", 2); //7 in binary
        int i3 = Integer.parseInt("ff", 16); //255 in hexadecimal

        float f = Float.parseFloat("1.01");
        double d = Double.parseDouble("1.010921721");

//        String err = (String) 10;

        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(f);
        System.out.println(d);

        String quote = "Never lend books-nobody ever returns them!";

        for(String word : quote.split(" ")){
            System.out.println(word);
        }
    }
}
