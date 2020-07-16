import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 可重入锁（也叫做递归锁）
 *     在同一个线程在外层方法获取锁的时候，在进入内层方法或会自动获取该锁。
 *     也就是说，线程可以进入任何一个他已经拥有的锁的同步代码块。
 *
 * case one Synchronized就是一个典型的可重入锁
 *      ----------case one----------
 *      case one thread1	获取值。。      //thread1线程在外层方法获得锁的时候
 *      ---case one thread1	存放值。。      //thread1在进入内层方法会自动获取锁
 *      case one thread2	获取值。。
 *      ---case one thread2	存放值。。
 *
 * case two ReentrantLock也是一个可重入锁
 *      ----------case two----------
 *      case two thread1	获取值。。     //thread1线程在外层方法获得锁的时候
 *      ###case two thread1	存放值。。     //thread1在进入内层方法会自动获取锁
 *      case two thread2	获取值。。
 *      ###case two thread2	存放值。。
 */



class Case {
    //case one Synchronized
    public synchronized void getNum() {
        System.out.println(Thread.currentThread().getName() + "\t获取值。。");
        setNum();
    }

    public synchronized void setNum() {
        System.out.println("---" + Thread.currentThread().getName() + "\t存放值。。");
    }

    //case two ReentrantLock
    private Lock lock = new ReentrantLock();
    public void get() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t获取值。。");
        set();
        lock.unlock();
    }

    public void set() {
        lock.lock();
        System.out.println("###" + Thread.currentThread().getName() + "\t存放值。。");
        lock.unlock();
    }
}


public class ReEnterLockDemo {
    public static void main(String[] args) {
        Case a = new Case();
        //case one Synchronized
        System.out.println("----------case one----------");

        new Thread(() -> {
            a.getNum();
        }, "case one thread1").start();

        new Thread(() -> {
            a.getNum();
        }, "case one thread2").start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //case two ReentrantLock
        System.out.println("\n\n----------case two----------");

        new Thread(() -> {
            a.get();
        }, "case two thread1").start();


        new Thread(() -> {
            a.get();
        }, "case two thread2").start();
    }
}
