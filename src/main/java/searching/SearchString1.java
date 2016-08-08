package searching;

public class SearchString1 {
    public static void main(String[] args) {
//        String string = "Vladimris";
//        System.out.println(string.length());
//        System.out.println(string.indexOf('V'));
//        System.out.println(string.indexOf('l'));
//        System.out.println(string.indexOf("is"));
//        System.out.println(string.indexOf('i'));
//        System.out.println(string.indexOf('i', 5));
//        System.out.println(string.indexOf("Vlads"));

        String string2 = "I am what am how am";

        String find = "hav";
        int index = 0;
        while(string2.indexOf(find, index) > -1){
            index = string2.indexOf(find, index);
            System.out.println(" Occurs at index: " + index);
            index++;
        }
//
//        System.out.println(string2.lastIndexOf("am"));
//        System.out.println(string2.startsWith("I"));
//        System.out.println(string2.endsWith("m"));

        String string3 = "Tarzan: Hi Jane, wanna ride an elephant? \n Jane: No thanks! I’m preparing for OCPJP now!";
        String match = " Jane: No thanks!";
        int ind = string3.indexOf('\n');
        System.out.println(ind);
        System.out.println(string3.charAt(ind+1));
        System.out.println(string3.indexOf(match));
        System.out.println(string3.regionMatches(ind+1, match, 0, match.length()));

    }
}
