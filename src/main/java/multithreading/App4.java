package multithreading;

import java.util.Arrays;

public class App4 {
    public static void main(String[] args) {
        Arrays.asList(Thread.State.values()).stream().forEach(System.out::println);
    }
}
