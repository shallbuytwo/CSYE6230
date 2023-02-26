public class Main {
    public static void main (String[] args) throws InterruptedException {
        int N = 300000000; // number of elements in the array.
        double[] arr = new double[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = 1;
            // Set the value to a random from [0.1, 0.9).
            arr[i] *= 0.1 + Math.random() * 0.8;
        }

        // We first compute the sum in serial.
        double sum = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; ++i) {
            sum += arr[i];
        }
        System.out.println("Computing the sum of " + N + " elements in serial took " + (System.currentTimeMillis() - startTime) + "ms. The sum is " + sum);

        // Then we do it in parallel.
        int numOfThreads = 3;
        double[] portionSum = new double[numOfThreads];
        Runnable[] runnables = new ComputationThread[numOfThreads];
        Thread[] threads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; ++i) {
            runnables[i] = new ComputationThread(arr, i, numOfThreads, portionSum);
            threads[i] = new Thread(runnables[i], "Thread " + i);
        }
        startTime = System.currentTimeMillis();
        // start all threads
        for (int i = 0; i < numOfThreads; ++i) {
            threads[i].start();
        }
        // join all threads and get the sum after that.
        sum = 0;
        for (int i = 0; i < numOfThreads; ++i) {
            threads[i].join();
            sum += portionSum[i];
        }
        System.out.println("Computing the sum of " + N + " elements in parallel took " + (System.currentTimeMillis() - startTime) + "ms. The sum is " + sum);
    }
}