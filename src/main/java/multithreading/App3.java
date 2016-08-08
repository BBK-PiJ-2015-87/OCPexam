package multithreading;

public class App3 {
    public static void main(String[] args) throws InterruptedException{
        Runnable r1 = () -> {
            try {
                B b = new B();
                b.m();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                B c = new B();
                c.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}

class B {

    public static synchronized void m() throws InterruptedException {
        for(;;){
            System.out.println("B");
            Thread.sleep(100);
        }

    }

    public static synchronized void a() throws InterruptedException {
        for(;;){
            System.out.println("A");
            Thread.sleep(100);
        }

    }
}


