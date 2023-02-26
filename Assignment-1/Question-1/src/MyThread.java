public class MyThread implements Runnable {
    String name; // thread name
    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        while (true) {
            // Print a statement. Then sleep for a random (but between 1 and 5) seconds.
            int seconds = 1 + (int)(Math.random() * 5);
            System.out.println("Thread " + name + " wakes up, going to sleep for " + seconds + " seconds...");

            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                System.out.println("Error happened when sleeping: " + e.getStackTrace());
            }
        }
    }
}
