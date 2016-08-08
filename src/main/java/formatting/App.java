package formatting;

public class App {
    public static void main(String[] args) {
        float f = 2.0241f;
        System.out.printf("float is %.2f \n", f);
        System.out.printf("float is %.2e \n", f);
        double d = 2.39487;
        System.out.printf("Double is %-15.4f \n", d);
        String s = "hello";
        System.out.printf("String is %-25s\n", s); //minimum 25 characters (will add spaces)
        int i = 12345;

        System.out.printf("Integer is : %25d%n", i);
        System.out.printf("Integer is : %025d%n", i);
        System.out.printf("Integer is : %-25d%n", i);
        System.out.printf("Integer is : %+25d%n", i);
        System.out.printf("Integer is : %+,25d%n%n", i); //, is used to separate thousands
        System.out.printf("Integer is : %d%n", i);

        long l = 1_000_000_999L;
        System.out.printf("Long is: %,-35d%n%n%n", l);
        System.out.printf("Long is: %,35d%n%n%n", l);
        System.out.println("this line should be separated with three line from the above");
    }
}
