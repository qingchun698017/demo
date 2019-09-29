package algorithm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by wqc on 2017/8/3.
 */
public class FutrueThread {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask =
                new FutureTask<String>(new Callable<String>() {
                    public String call() {
                        //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            System.out.println("interruptered");
                        }
                        return "haha";
                    }
                });
        executor.execute(futureTask);
        //在这里可以做别的任何事情
        String result=null;
        try {
            //取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果
            result = futureTask.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            futureTask.cancel(true);
        } catch (ExecutionException e) {
            futureTask.cancel(true);
        } catch (TimeoutException e) {
            futureTask.cancel(true);
        } finally {
            executor.shutdown();
        }
        System.out.println(result);
    }

}
