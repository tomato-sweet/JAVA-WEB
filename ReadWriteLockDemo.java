import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: acmPractice
 * @description: 读写锁案例
 * @author: Mr.Li
 * @create: 2019-09-26 16:46
 *
 *  多个线程同时读一个资源类没有问题，所以为了满足并发量，读取共享资源应该同时进行
 *  但是如果有一个线程想去写共享资源，就不应该再有其他线程可以对资源进行读或取
 *
 *  总结：读读能共存，读写不能共存，写写不能共存
 *      写操作：原子+独占，整个过程必须是一个完整的统一体，中间不许被分割、被打断
 *
 **/

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void put(String key, Object value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 正在写入..." + key);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " 写入完成，写入结果是 " + value);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        try {
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 正在读...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object res = map.get(key);
            System.out.println(Thread.currentThread().getName() + " 读取完成，读取结果是 " + res);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.put(temp + "", temp + "");
            },
            String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.get(temp + "");
            },String.valueOf(i)).start();
        }
    }
}
