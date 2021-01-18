package JavaThreeLessonFour;

public class Streams {

    private final Object mon = new Object();
    private volatile char Letter = 'A';

    public static void main(String[] args) {
        Streams w = new Streams();
        Thread t1 = new Thread(() -> {
            w.printA();
        });
        Thread t2 = new Thread(() -> {
            w.printB();
        });
        Thread t3 = new Thread(() -> {
            w.printC();
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA(){
        synchronized (mon) {
            try{
                for (int i = 0; i < 5; i++) {
                    while (Letter != 'A'){
                        mon.wait();
                    }
                    System.out.println("A");
                    Letter = 'B';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (mon) {
            try{
                for (int i = 0; i < 5; i++) {
                    while (Letter != 'B'){
                        mon.wait();
                    }
                    System.out.println("B");
                    Letter = 'C';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printC(){
        synchronized (mon) {
            try{
                for (int i = 0; i < 5; i++) {
                    while (Letter != 'C'){
                        mon.wait();
                    }
                    System.out.println("C");
                    Letter = 'A';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
