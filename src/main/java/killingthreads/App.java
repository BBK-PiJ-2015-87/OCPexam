package killingthreads;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vladimirsivanovs on 14/06/2016.
 */
public class App {
    public static void main(String[] args) {
        Runnable runnable = () -> {
          while(true){
              System.out.println("I'm alive");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        int counter = 0;

        while(true){

            System.out.println(counter);
            counter++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (counter == 5) {
                System.exit(1);
            }

            Set set = new HashSet<>();
        }
    }
}
