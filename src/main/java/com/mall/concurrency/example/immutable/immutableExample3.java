package com.mall.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * immutableExample3 class
 *
 * @author Flc
 * @date 2019/7/9
 */
public class immutableExample3 {

    private final static ImmutableList list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap map=ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap map2=ImmutableMap.<Integer,Integer>builder()
            .put(1,2).put(3,4).put(5,6).build();

    public static void main(String[] args) {
//        list.add(4);
//        set.add(6);
//        map.put(5,4);
        System.out.println(map2.get(3));
    }
}
