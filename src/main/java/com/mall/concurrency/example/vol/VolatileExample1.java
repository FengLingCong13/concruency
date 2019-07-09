package com.mall.concurrency.example.vol;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * VolatileExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 */
@Slf4j
public class VolatileExample1 {
    public volatile static boolean happend=false;

    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(()->{
            test();
        });
        service.execute(()->{
            while(!happend){
                log.info("进行");
            }
            log.info("成功");
        });
    }

    public static void test(){
        for(int i=0;i<=1000000000;i++){
            if(i==1000000000){
                happend=true;
            }
        }
    }
}
