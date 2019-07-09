package com.mall.concurrency.example.publish;

import com.mall.concurrency.annotation.NotRecommend;
import com.mall.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * UnSafePublish class
 *
 * @author Flc
 * @date 2019/7/9
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

   private int thisCanBeEscape=0;

   public Escape(){
        new InnerClass();
   }

   private class InnerClass{
       public InnerClass(){
           log.info("{}",Escape.this.thisCanBeEscape);
       }
   }

    public static void main(String[] args) {
        new Escape();
    }
}
