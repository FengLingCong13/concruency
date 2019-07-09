package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotation.NotThreadSafe;
import com.mall.concurrency.annotation.ThreadSafe;

/**
 * SingletonExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 * 饿汉模式
 */
@NotThreadSafe
@ThreadSafe
public class SingletonExample2 {

    //私有构造方法
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance=new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
