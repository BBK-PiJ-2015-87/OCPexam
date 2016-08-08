package multithreading;

import java.util.Scanner;

public class App {
    public static int counter = 0;
    public static void main(String[] args) {
        System.out.println("Initial hello from thread : " + Thread.currentThread().getName());
        Counter counter = new Counter();
        InputTaker inputTaker = new InputTaker();
        Thread runnable = new Thread(new HelloRunnable());
        runnable.setName("RUNNABLE-THREAD");
        runnable.setPriority(10);

        counter.start();
        inputTaker.start();
        runnable.start();

    }
}

class Counter extends Thread{

    @Override
    public void run(){
        this.setPriority(1);
        this.setName("COUNTER-THREAD");
        while (App.counter < 10000000){
            System.out.println(App.counter + " in Thread " + this);
            App.counter++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class InputTaker extends Thread{
    Scanner sc = new Scanner(System.in);

    @Override
    public void run(){
        this.setName("INPUT-THREAD");
        this.setPriority(1);
        while(App.counter != -1){
            System.out.println("enter new counter number " + this);
            int input = sc.nextInt();
            System.out.println("You entered : " + input + " in Thread " + this);
            App.counter = input;
        }
    }

}

class HelloRunnable implements Runnable {

    @Override
    public void run(){
        while(true){
            System.out.println("this is hello from Thread : " + Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
