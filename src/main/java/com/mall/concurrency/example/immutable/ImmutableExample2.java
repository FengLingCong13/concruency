package com.mall.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.mall.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * ImmutableExample1 class
 *
 * @author Flc
 * @date 2019/7/9
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer,Integer> map=Maps.newHashMap();

    static{
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map= Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,3);
    }

    private void test(final int a){
    }
}
