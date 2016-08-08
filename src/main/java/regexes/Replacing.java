package regexes;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

public class Replacing {
    public static void main(String[] args) {
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        Pattern emails = Pattern.compile("\\w+@\\w+\\.com");
        Pattern phoneNumbers = Pattern.compile("(\\d{3})(\\d{7})"); //we have two groups. Can reference with $1 and $2
        Pattern phoneNumbers2 = Pattern.compile("(\\d{3})(\\d{3})(\\d{4})");
        Matcher matcher = emails.matcher(str);

        matcher.usePattern(phoneNumbers2);

        String newStr = matcher.replaceAll("$1-$2-$3");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

//        String newStr = matcher.replaceAll("vlad@gmail.com"); //replaced all email with a new one
        System.out.println(newStr);
    }

}

class IPRegex{
    public static void main(String[] args) {
        List<String> ips = Arrays.asList(
                "111.121.212.111",
                "0.0.0.0",
                "255.255.255.255",
                "111.121.212.256"
        );

        final String regex = "\\b((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)(\\.)){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\b";

        ips.stream().forEach(x -> System.out.println(Pattern.matches(regex, x)));
    }
}
