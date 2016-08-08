package multithreading;

/**
 * Created by vladimirsivanovs on 13/06/2016.
 */
public class App2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAIN is : " + Thread.currentThread().getState());
        Bomb bomb = new Bomb();
        System.out.println("BOMB is: " + bomb.getState());
        bomb.start();
        bomb.join();
        System.out.println("BOOM!!!");
        System.out.println("BOMB is: " + bomb.getState());
        System.out.println("MAIN is : " + Thread.currentThread().getState());

    }
}

class Bomb extends Thread{
    String[] count = {"ONE", "TWO", "THREE", "FOUR", "FIVE"};

    @Override
    public void run() {
        Thread main = null;
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t.getName().equals("main")) {
                main = t;
            }
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println(count[i]);
            System.out.println("BOMB is: " + this.getState());
            System.out.println("MAIN is: " + main.getState());


            if (i == 2) {
//                notifyAll();
            }
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
