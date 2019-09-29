package algorithm;

import java.util.concurrent.TimeUnit;

/**
 * Created by wqc on 2017/8/2.
 * 写死锁最主要的是创建一个线程互相等待结果的状态，
 * 最简单的就是在一个线程锁住一个对象1的时候去请求对象2，
 * 而第二个线程在锁住对象2的同时去请求对象1，
 */
public class DeadLock implements Runnable {
    public boolean flag;
    //静态的对象，被DeadLockTest的所有实例对象所公用
    private static TestThreadObject o1 = new TestThreadObject();
    private static TestThreadObject o2 = new TestThreadObject();


    private DeadLock(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public void run()
    {
        String sname = Thread.currentThread().getName();
        if(flag)
        {
            try {
                o1.lock.lock();
                System.out.println(sname + "获取o1锁。。。。。。。。");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true)
                {
                    if(o2.lock.tryLock(10000, TimeUnit.MILLISECONDS))
                    {
                        System.out.println(sname + "获取o2锁。。。。。。。。");
                        break;
                    }else{
                        System.out.println(sname + "未获取o2锁,死锁10秒，解开o1锁。。。。。。。。");
                        o1.lock.unlock();
                    }
                }



            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (o2.lock.isLocked())
                {
                    o2.lock.unlock();
                    System.out.println(sname + "释放o2锁。。。。。。。。");
                }
            }

        }else{
            try {
                o2.lock.lock();
                System.out.println(sname + "获取o2锁。。。。。。。。");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true)
                {
                    if(o1.lock.tryLock(10000, TimeUnit.MILLISECONDS))
                    {
                        System.out.println(sname + "获取o1锁。。。。。。。。");
                        break;
                    }else{
                        System.out.println(sname + "未获取o1锁,死锁10秒，解开o2锁。。。。。。。。");
                        o2.lock.unlock();
                    }
                }

            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if (o1.lock.isLocked())
                {
                    o1.lock.unlock();
                    System.out.println(sname + "释放o1锁。。。。。。。。");
                }
                if (o2.lock.isLocked())
                {
                    o2.lock.unlock();
                    System.out.println(sname + "释放o2锁。。。。。。。。");
                }
            }

        }
        System.out.println(sname +"结束。。。。。。。。");
    }

    public static void main(String[] args) {
        Thread new1 = new Thread(new DeadLock(true));
        Thread new2 = new Thread(new DeadLock(false));
        new1.setName("thread1");
        new2.setName("thread2");
        new1.start();
        new2.start();
    }
}
