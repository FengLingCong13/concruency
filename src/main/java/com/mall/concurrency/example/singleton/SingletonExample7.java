package com.mall.concurrency.example.singleton;

import com.mall.concurrency.annotation.Recommend;
import com.mall.concurrency.annotation.ThreadSafe;


/**
 * 枚举模式：最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造函数
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Sigleton.INSTANCE.getInstance();
    }

    private enum Sigleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只被调用一次
        Sigleton(){
            singleton=new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
