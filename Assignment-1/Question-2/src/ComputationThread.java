// This thread will only compute elements whose index satisfies idx % numOfThreads == threadID.
public class ComputationThread implements Runnable {
    private double arr[]; // original elements array.
    private double portionSum[]; // the array for us to put our portionSum to. We will put to portionSum[threadID].
    private int threadID; // Range is [0, numOfThreads - 1].
    private int numOfThreads; // Total number of threads.
    public ComputationThread(double[] arr, int threadID, int numOfThreads, double[] portionSum) {
        this.arr = arr;
        this.threadID = threadID;
        this.numOfThreads = numOfThreads;
        this.portionSum = portionSum;
    }

    public void run() {
        double sum = 0;
        for (int i = threadID; i < arr.length; i += numOfThreads) {
            sum += arr[i];
        }
        portionSum[threadID] = sum;
    }
}
