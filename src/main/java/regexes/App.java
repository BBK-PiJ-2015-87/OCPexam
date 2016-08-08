package regexes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vladimirsivanovs on 13/06/2016.
 */
public class App {
    public static void main(String[] args) {
        String string = "Hello hoho ho 1234 ho top";
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";
//        Pattern pattern = Pattern.compile("\\w"); //matches any character
//        Pattern pattern = Pattern.compile("\\w+"); //matches any word
//        Pattern pattern = Pattern.compile("\\D+"); //matches all non digits
//        Pattern pattern = Pattern.compile("\\W+"); //matches all non word characters
        Pattern pattern = Pattern.compile("\\d+"); //matches all numbers
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
//        System.out.println(string.matches("Hello(.*)"));
//        System.out.println(string.matches("(.*)top$"));
//        System.out.println(string.matches(".*"));
//        System.out.println(string.matches("^[Hab]ello(.*)"));
//        System.out.println(string.matches("[HAB]ello(.*)"));
//        System.out.println(string.matches("H(.*)"));
//        System.out.println(string.matches("^He(.*)hoho(.*)"));
//        System.out.println(string.matches("[^1-9](.*)hoho(.*)"));
        System.out.println(string.matches("H[^1-9](l+)o+(\\s)(b+)*(h+o+){0,200}(\\s)ho{0,}(\\s)[1-4]*(\\s)[ho]*(\\s)[top]*"));
    }
}
