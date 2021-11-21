package datastructure.Concurrency;

public class Semaphore {

}

class SimpleSemapore {
    boolean signalled = false;

    public synchronized void take() throws InterruptedException {
        signalled = true;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (!signalled)
            wait();
        signalled = false;
    }
}

class CountingSemaphore {
    int count = 0;

    public synchronized void take() throws InterruptedException {
        count++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (count != 0)
            wait();
        count--;
    }
}