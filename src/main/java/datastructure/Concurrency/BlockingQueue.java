package datastructure.Concurrency;

public class BlockingQueue<T extends Comparable<T>> {
    int capacity;
    java.util.Queue<T> blockingQueue = new java.util.LinkedList<>();

    BlockingQueue(int size) {
        this.capacity = size;
    }

    public synchronized void enQueue(T value) throws InterruptedException {
        if (blockingQueue.size() == capacity)
            wait();
        blockingQueue.offer(value);
        //multipl threads might use
        if (blockingQueue.size() == 1)
            notifyAll();
    }

    public synchronized T deQueue() throws InterruptedException {
        if (blockingQueue.size() == 0)
            wait();
        T value = blockingQueue.poll();
        if (blockingQueue.size() == capacity)
            notifyAll();
        return value;
    }

}
