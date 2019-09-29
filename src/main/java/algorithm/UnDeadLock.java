package algorithm;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by wqc on 2017/8/27.
 */

public class UnDeadLock {
    public static String bowl = "碗";
    //信号量可以碗只能能被一个线程同时访问
    public static final Semaphore a1 = new Semaphore(1);
    public static String chopsticks = "筷子";
    //信号量可以筷子只能能被一个线程同时访问
    public static final Semaphore a2 = new Semaphore(1);

    public static void main(String[] args) {
        LockAa la = new LockAa();
        new Thread(la).start();
        LockBa lb = new LockBa();
        new Thread(lb).start();
    }

}


class LockAa implements Runnable {
    public void run() {
        try {
            System.out.println(new Date().toString() + "邹保健开始拿餐具吃饭");
            while (true) {
                if (UnDeadLock.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + "邹保健抢到了碗");
                    if (UnDeadLock.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + "邹保健抢到了筷子,凑齐了餐具,准备吃饭");
                        Thread.sleep(60 * 1000 * 10); // 抢到餐具就开始吃饭,吃饭时间十分钟
                    } else {
                        System.out.println(new Date().toString() + "筷子已经被抢走了,邹保健抢筷子失败");
                    }
                } else {
                    System.out.println(new Date().toString() + "碗已经被抢走了,邹保健抢碗失败");
                }

                UnDeadLock.a1.release(); // 释放
                UnDeadLock.a2.release();
                System.out.println(new Date().toString() + "邹保健把抢到的部分餐具又放回原处");
                Thread.sleep(1000); // 马上进行尝试，现实情况下do something是不确定的
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class LockBa implements Runnable {
    public void run() {
        try {
            System.out.println(new Date().toString() + "陈顶天开始拿餐具吃饭");
            while (true) {
                if (UnDeadLock.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + "陈顶天抢到了筷子");
                    if (UnDeadLock.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + "陈顶天抢到了碗,凑齐了餐具,准备吃饭");
                        Thread.sleep(60 * 1000 * 10); // 抢到餐具就开始吃饭,吃饭时间十分钟
                    } else {
                        System.out.println(new Date().toString() + "碗已经被抢走了,陈顶天抢碗失败");
                    }
                } else {
                    System.out.println(new Date().toString() + "筷子已经被抢走了,陈顶天抢筷子失败");
                }

                UnDeadLock.a1.release(); // 释放
                UnDeadLock.a2.release();
                System.out.println(new Date().toString() + "陈顶天把抢到的部分餐具又放回原处");
                Thread.sleep(10 * 1000);//这里只是为了演示，所以tryAcquire只用1秒，而且B要给A让出能执行的时间，否则两个永远是死锁
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
