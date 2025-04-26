// Shared class (buffer) 
class SharedBuffer { 
    int data; 
    boolean hasData = false; 

    // Producer puts data into buffer 
    synchronized void produce(int value) throws InterruptedException { 
        while (hasData) { 
            wait(); // Wait until buffer is empty 
        } 
        data = value; 
        System.out.println("Produced: " + data); 
        hasData = true; 
        notify(); // Notify consumer 
    } 

    // Consumer takes data from buffer 
    synchronized void consume() throws InterruptedException { 
        while (!hasData) { 
            wait(); // Wait until buffer has data 
        } 
        System.out.println("Consumed: " + data); 
        hasData = false; 
        notify(); // Notify producer 
    } 
} 

// Producer thread 
class Producer extends Thread { 
    SharedBuffer buffer; 

    Producer(SharedBuffer buffer) { 
        this.buffer = buffer; 
    } 

    public void run() { 
        for (int i = 1; i <= 5; i++) { 
            try { 
                buffer.produce(i); 
                Thread.sleep(500); // Simulate time to produce 
            } catch (InterruptedException e) { 
                System.out.println(e); 
            } 
        } 
    } 
} 

// Consumer thread 
class Consumer extends Thread { 
    SharedBuffer buffer; 

    Consumer(SharedBuffer buffer) { 
        this.buffer = buffer; 
    } 

    public void run() { 
        for (int i = 1; i <= 5; i++) { 
            try { 
                buffer.consume(); 
                Thread.sleep(500); // Simulate time to consume 
            } catch (InterruptedException e) { 
                System.out.println(e); 
            } 
        } 
    } 
} 

// Main class 
public class ITC { 
    public static void main(String[] args) { 
        SharedBuffer buffer = new SharedBuffer(); 

        Producer p = new Producer(buffer); 
        Consumer c = new Consumer(buffer); 

        p.start(); 
        c.start(); 
    } 
} 
