package com.xq.javalib;

/**
 * Desc：
 */
public class Web12306 implements Runnable{
    //票数
    private int ticketNums = 99;

    @Override
    public void run() {
        while(true) {
            if(ticketNums<0) {
                break;
            }
            //模拟延时，此时会出现数据问题，所以要处理涉及到并发。
            try {
                Thread.sleep(200);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"周杰伦").start();
        new Thread(web,"许嵩").start();
        new Thread(web,"汪苏泷").start();
    }
}
