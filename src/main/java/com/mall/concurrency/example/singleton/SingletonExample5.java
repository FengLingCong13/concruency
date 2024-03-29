package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotation.NotRecommend;
import com.mall.concurrency.annotation.ThreadSafe;

/**
 * SingletonExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 * 懒汉模式  双重同步锁单例模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample5 {

    //私有构造方法
    private SingletonExample5(){

    }

    //1、memory=allocate() 分配对象内存空间
    //2、ctorInstance()初始化对象
    //3、instance=memory 设置instance指向刚分配的内存


    //单例对象  volatile+双重检测机制 限制指令重排
    private volatile static SingletonExample5 instance=null;

    //静态的工厂方法
    public static SingletonExample5 getInstance(){
        if(instance==null){     //双重检测
            synchronized (SingletonExample5.class) {    //同步锁
                if(instance==null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
