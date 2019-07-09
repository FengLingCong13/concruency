package com.mall.concruency.example.atomic;

import com.mall.concruency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * ConcurrencyTest class
 *
 * @author Flc
 * @date 2019/7/6
 */
@Slf4j
@ThreadSafe
public class AtomicExample6 {

    private static AtomicReferenceFieldUpdater<AtomicExample6, Integer> updater = AtomicReferenceFieldUpdater.newUpdater(AtomicExample6.class, Integer.class, "count");

    @Getter
    public volatile Integer count = 100;

    private static AtomicExample6 example6 = new AtomicExample6();

    public static void main(String[] args) {
        if (updater.compareAndSet(example6, 100, 150)) {
            log.info("update success,{}", example6.getCount());
        }
        if (updater.compareAndSet(example6, 100, 150)) {
            log.info("update success,{}", example6.getCount());
        }else{
            log.info("update failed,{}", example6.getCount());
        }
    }
}
