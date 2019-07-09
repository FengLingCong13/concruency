package com.mall.concurrency.example.threadLocal;

public class RequestHolder {

   private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();

   public static void add(Long id){
       threadLocal.set(id);
   }

   public static Long get(){
       return threadLocal.get();
   }

   public static void remove(){
       threadLocal.remove();
   }

}
