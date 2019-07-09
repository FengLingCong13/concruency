package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotation.NotRecommend;
import com.mall.concurrency.annotation.NotThreadSafe;

/**
 * SingletonExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 * 懒汉模式  双重同步锁单例模式
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample4 {

    //私有构造方法
    private SingletonExample4(){

    }

    //1、memory=allocate() 分配对象内存空间
    //2、ctorInstance()初始化对象
    //3、instance=memory 设置instance指向刚分配的内存

    //JVM和CPU优化，发生了指令重排

    //1、memory=allocate() 分配对象内存空间
    //3、instance=memory 设置instance指向刚分配的内存
    //2、ctorInstance()初始化对象

    //单例对象
    private static SingletonExample4 instance=null;

    //静态的工厂方法
    public static SingletonExample4 getInstance(){
        if(instance==null){     //双重检测
            synchronized (SingletonExample4.class) {    //同步锁
                if(instance==null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
