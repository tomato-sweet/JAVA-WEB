import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;



/**
 * @description: 手写自旋锁
 * @author: Mr.Li
 * @create: 2019-09-26 16:31
 *
 * 优点：不会阻塞
 * 缺点：可能一直处于循环
 *
 * 获取锁的时候，如果原子引用为空就获取锁，不为空表示有人获取了锁，就循环等待。
 * 程序输出：
 *      AA	 come in ♀
 *      BB	 come in ♀
 *      AA	success unlock...
 *      BB	success unlock...
 **/

public class SpinLock {
    //原子引用线程
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();
    private void lock () {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in ♀");
        while (!atomicReference.compareAndSet(null, thread)) {
            // loop
        }
    }

    private void unlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\tsuccess unlock...");
    }

    public static void main(String[] args){
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            spinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unlock();
        },"AA").start();

        //等待一秒
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLock.lock();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unlock();
        },"BB").start();
    }
}
