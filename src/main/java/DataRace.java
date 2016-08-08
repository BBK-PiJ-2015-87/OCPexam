public class DataRace {
    public int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 20; i > 0; i--){
            SharedData data = new SharedData();
            Incrementer2 incrementer2 = new Incrementer2(data);
            Incrementer3 incrementer3 = new Incrementer3(data);
            incrementer2.start();
            incrementer3.start();

            Thread.sleep(3000);
            System.out.println(data.data);
        }


    }

    public int getCounter(){
        return counter;
    }
}

class SharedData{
    public int data = 0;
}

class Incrementer2 extends Thread{
    private SharedData data;

    Incrementer2(SharedData data){
        this.data = data;
    }

    public void increment(){
        data.data += 2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        increment();
        increment();
        increment();
        increment();
        increment();
    }
}

class Incrementer3 extends Thread{
    private SharedData data;

    Incrementer3(SharedData data){
        this.data = data;
    }

    public void increment(){
        data.data += 3;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        increment();
        increment();
        increment();
        increment();
        increment();

    }
}