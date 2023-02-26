public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable rA = new MyThread("A");
        Runnable rB = new MyThread("B");
        Runnable rC = new MyThread("C");
        Runnable rD = new MyThread("D");

        Thread tA = new Thread(rA, "Thread A");
        Thread tB = new Thread(rB, "Thread B");
        Thread tC = new Thread(rC, "Thread C");
        Thread tD = new Thread(rD, "Thread D");

        tA.start();
        tB.start();
        tC.start();
        tD.start();

        tA.join();
        tB.join();
        tC.join();
        tD.join();
    }
}