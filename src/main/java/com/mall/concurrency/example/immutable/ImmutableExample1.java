package com.mall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * ImmutableExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a=1;
    private final static String b="2";
    private final static Map<Integer,Integer> map= Maps.newHashMap();

    static{
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        //引用类型允许修改值，但是不允许指向新的对象
        //基础数据类型值也不允许修改
        map.put(1,3);
        log.info("{}",map.get(1));
    }

    private void test(final int a){
//        a=4;
    }
}
