package com.mall.concurrency.example.atomic;

import com.mall.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * ConcurrencyTest class
 *
 * @author Flc
 * @date 2019/7/6
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {


    public static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 2);
        count.compareAndSet(0, 1);
        count.compareAndSet(1, 3);
        count.compareAndSet(2, 4);
        count.compareAndSet(3, 5);
        log.info("count:{}",count.get());
    }
}
