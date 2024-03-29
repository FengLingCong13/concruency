package com.mall.concurrency.example.atomic;

import com.mall.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 * ConcurrencyTest class
 *
 * @author Flc
 * @date 2019/7/6
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    //判断是否只执行一次
    public static AtomicBoolean isHappened=new AtomicBoolean(false);
    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    //计数
    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0;i < clientTotal;i++){
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    //add();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count );
    }

    public static void test(){
        if(isHappened.compareAndSet(false,true)){
            System.out.println("执行一次");
        }
    }
    /**
     * 计数的方法
     */
    private static void add(){
        count.increment();
    }
}
