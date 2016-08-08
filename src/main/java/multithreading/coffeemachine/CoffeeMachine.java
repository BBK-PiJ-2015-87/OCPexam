package multithreading.coffeemachine;

class CoffeeMachine extends Thread {
    static String coffeeMade = null;
    static final Object lock = new Object();
    private static int coffeeNumber = 1;

    void makeCoffee() {
        synchronized (CoffeeMachine.lock) {
            if (coffeeMade != null) {
                try {
                    System.out.println("Coffee machine: Waiting for waiter notification to deliver the coffee");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }

            coffeeMade = "Coffee No. " + coffeeNumber++;
            System.out.println("Coffee machine says: Made " + coffeeMade);
            CoffeeMachine.lock.notifyAll();
            System.out.println("Coffee machine: Notifying waiter to pick the coffee ");
        }
    }

    public void run() {
        while (true) {
            makeCoffee();
            try {
                System.out.println("Coffee machine: Making another coffee now");
                Thread.sleep(10000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

class Waiter extends Thread{
    public void getCoffee() {
        synchronized (CoffeeMachine.lock) {
            if (CoffeeMachine.coffeeMade == null) {
                try {
                    System.out.println("waiter: will get orders until machine makes coffee");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
                CoffeeMachine.coffeeMade = null;
                CoffeeMachine.lock.notify();
                System.out.println("Waiter: Notifying coffee machine to make another one");
        }
    }

    public void run() {
        while (true) {
            getCoffee();
        }
    }
}

class Runner{
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Waiter waiter = new Waiter();

        coffeeMachine.start();
        waiter.start();
    }
}

