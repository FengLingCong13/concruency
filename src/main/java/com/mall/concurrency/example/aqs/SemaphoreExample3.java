package com.mall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch1 class
 *
 * @author Flc
 * @date 2019/7/10
 */
@Slf4j
public class SemaphoreExample3 {

    private static int threadCount=20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    if(semaphore.tryAcquire(1, TimeUnit.SECONDS)){     //尝试获取一个许可
                        test(threadNum);
                        semaphore.release();    //释放一个许可
                    }
                } catch (InterruptedException e) {
                    log.error("exception:", e);
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("threadNum: {}", threadNum);
        Thread.sleep(1000);
    }
}
