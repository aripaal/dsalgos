package datastructure.Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Contains worker threads(PoolThreadRunnable) which will feed off a BlockingQueue
 * and execute them. ThreadPool should supply runnable tasks for it to execute.
 */
public class ThreadPool {

    //Size of the blockingQueue is the MaxNoOfTasks it can handle
    java.util.concurrent.BlockingQueue<Runnable> taskQueue;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    //noOfThreads are the no of worker threads
    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new ArrayBlockingQueue<>(maxNoOfTasks);
        for(int i=0;i<noOfThreads;i++){
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
            runnables.add(poolThreadRunnable);
        }

        for(PoolThreadRunnable poolThreadRunnable:runnables)
            new Thread(poolThreadRunnable).start();
    }

    /**
     * Add the task in the taskQueue
     */
    public synchronized void execute(Runnable task) throws Exception{
        if(this.isStopped)
            throw new IllegalStateException("ThreadPool is stopped");
        this.taskQueue.offer(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThreadRunnable runnable : runnables){
            runnable.stop();
        }
    }

//    public synchronized void waitUntilAllTasksFinished() {
//        while(this.taskQueue.size() > 0) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    //Workers
    class PoolThreadRunnable implements Runnable {
        java.util.concurrent.BlockingQueue<Runnable> taskQueue;
        Thread thread;
        private boolean isStopped;

        public PoolThreadRunnable(BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }

        /**
         * only purpose is to feed from the blockingQueue
         * and execute run() on it.
         */
        @Override
        public void run() {
            this.thread = Thread.currentThread();
            while (!isStopped) {
                try {
                    taskQueue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void stop(){
            isStopped = true;
            thread.interrupt();
        }
    }
}
