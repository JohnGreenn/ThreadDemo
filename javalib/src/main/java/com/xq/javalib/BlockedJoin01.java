package com.xq.javalib;

/**
 * join合并线程，待此线程执行完成后，再执行其他线程，其他线程阻塞
 * Desc：join合并线程，插队线程
 */
public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for(int i = 0; i < 100; i++) {
                System.out.println("lambda....." +i);
            }
        });
        t.start();

        for(int i = 0; i < 100; i++) {
            if(i==20){
                t.join(); //插队 main被阻塞了(等lambda执行完，才能执行我自己)
            }
            System.out.println("main....."+i);
        }
    }
}
