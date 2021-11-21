package datastructure.Concurrency;

public class Lock {
}


class SimpleLock {
    boolean isLocked;
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unLock() throws InterruptedException {
        isLocked = false;
        notify();
    }
}

class ReentrantLock {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        while (isLocked == true && currentThread != lockedBy) {
            wait();
        }
        lockedBy = currentThread;
        ++lockedCount;
        isLocked = true;
    }


    public synchronized void unLock() throws InterruptedException {

        if (lockedBy == Thread.currentThread()) {
            --lockedCount;
        }

        if (lockedCount == 0) {
            isLocked = false;
            notifyAll();
        }
    }
}


