package ocp.concurrency.threadsafe;

/**
 * Reentrant lock
 * void lock() - request and blocks until lock is acquired
 * void unlock() - release lock
 * boolean tryLock() - request a lock and get immediately, boolean value about if it is acquired
 * boolean tryLock(long, TimeUnit)
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {

    public static void main(String[] args) {

        //if release lock you do not catch then IllegalMonitorStateException will be thrown
        ReentrantLock lock = new ReentrantLock();
        //lock.unlock();

        new Thread(() -> printMessage(lock)).start();
        if (lock.tryLock()) {
            try {
                System.out.println("Lock obtained :" + lock.getHoldCount() + ", " + lock.getQueueLength());
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Lock was not obtained :" + lock);
        }

    }

    public static void printMessage(Lock lock) {
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }
}
