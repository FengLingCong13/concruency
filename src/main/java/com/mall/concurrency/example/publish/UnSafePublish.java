package com.mall.concurrency.example.publish;

import com.mall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * UnSafePublish class
 *
 * @author Flc
 * @date 2019/7/9
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {

    private String[] states={"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args){
        UnSafePublish unSafePublish=new UnSafePublish();
        log.info("{}", Arrays.toString(unSafePublish.getStates()));
        unSafePublish.getStates()[0]="d";
        log.info("{}", Arrays.toString(unSafePublish.getStates()));
    }
}
