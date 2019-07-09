package com.mall.concruency.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SychronizedExample1 class
 *
 * @author Flc
 * @date 2019/7/8
 */
@Slf4j
public class SychronizedExample2 {

    //修饰一个类
    public static void test1(int j) {
        synchronized (SychronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1- {}-{}", j, i);
            }
        }
    }

    //修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2- {}-{}",j, i);
        }
    }

    public static void main(String[] args) {
        SychronizedExample2 example1 = new SychronizedExample2();
        SychronizedExample2 example2 = new SychronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
