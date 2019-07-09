package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotation.ThreadSafe;

/**
 * SingletonExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 * 饿汉模式
 */

@ThreadSafe
public class SingletonExample6 {

    //私有构造方法
    private SingletonExample6(){

    }

    private static SingletonExample6 instance=null;

    //单例对象
    static{
        instance=new SingletonExample6();
    }


    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
