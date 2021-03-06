package algorithm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wqc on 2017/8/3.
 */
public class TimeLock extends ReentrantLock {
    @Override
    public void lock() {
        super.lock();
        long start = System.currentTimeMillis();
        while (true){
            if (System.currentTimeMillis() - start > 1000 * 15){
                super.unlock();
            }
        }
    }
}
