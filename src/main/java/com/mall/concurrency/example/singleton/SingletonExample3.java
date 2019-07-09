package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotation.NotRecommend;
import com.mall.concurrency.annotation.ThreadSafe;

/**
 * SingletonExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 * 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造方法
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance=null;

    //静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if(instance==null){
            instance=new SingletonExample3();
        }
        return instance;
    }
}
