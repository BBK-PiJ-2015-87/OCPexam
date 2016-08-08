package regexes;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App2 {
    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";
        Pattern pattern = Pattern.compile("\\w+");
        Pattern any5digits = Pattern.compile("\\d{5}"); //all substring with 5 digits
        Pattern digits5AndOtherCharacters = Pattern.compile("\\D\\d{5}\\D"); //all numbers just with 5 digits
        Pattern just5digits = Pattern.compile("\\b\\d{5}\\b"); //use word boundaries to get rid of white space and comma
        Pattern phoneNumbers = Pattern.compile("\\b\\d{10}\\b");
        Pattern emails = Pattern.compile("\\w+@\\w+.\\w+");

        Matcher matcher = pattern.matcher(str);
        matcher.usePattern(emails);

        while (matcher.find()) {
            System.out.println(matcher.group());
//            System.out.println(str.substring(matcher.start(), matcher.end()));
//            System.out.println(str.subSequence(matcher.start(), matcher.end()));
//            matcher.reset(); //infinite loop (starts from the beginning)
        }
    }
}
