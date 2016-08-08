package regexes.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] s) {
        String quote = "Never lend books-nobody ever returns them!";
        String [] words = quote.split(" ", 4);
        // split strings based on the delimiter " " (space)
        for (String word : words) {
            System.out.println(word);
        }

        String test = "I spy with my little eye ...";
        Pattern pattern = Pattern.compile("\\w*");
        Matcher matcher = pattern.matcher(test);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
