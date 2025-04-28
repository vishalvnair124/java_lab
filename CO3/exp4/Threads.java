// Class to generate Fibonacci numbers 
class FibonacciThread extends Thread {
    private int count;

    public FibonacciThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        int a = 0, b = 1;
        System.out.println("Fibonacci Series:");
        for (int i = 0; i < count; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println("\n");
    }
}

// Class to display even numbers in a range
class EvenNumberThread extends Thread {
    private int start, end;

    public EvenNumberThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("Even Numbers between " + start + " and " + end + ":");
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
    }
}

// Main class to run the threads
public class Threads {
    public static void main(String[] args) {
        FibonacciThread fibThread = new FibonacciThread(10); // 10 Fibonacci numbers
        EvenNumberThread evenThread = new EvenNumberThread(1, 20); // Even numbers from 1 to 20
        fibThread.start();
        evenThread.start();
    }
}