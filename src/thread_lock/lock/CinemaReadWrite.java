package thread_lock.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CinemaReadWrite {

    private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 获取了读锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + " 释放了读锁");
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 获取了写锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + " 释放了写锁");
        }
    }

    public static void main(String[] args) {
        new Thread(() -> read(), "Thread1").start();
        new Thread(() -> read(), "Thread2").start();
        new Thread(() -> write(), "Thread3").start();
        new Thread(() -> write(), "Thread4").start();
    }
}
