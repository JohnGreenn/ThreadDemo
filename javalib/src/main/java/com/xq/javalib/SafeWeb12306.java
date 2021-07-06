package com.xq.javalib;

/**
 * Desc：线程安全：在并发时保证数据的正确性
 */
public class SafeWeb12306 implements Runnable{

    public static void main(String[] args) {
        //一份资源
        SafeWeb12306 web = new SafeWeb12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"周杰伦").start();
        new Thread(web,"许嵩").start();
        new Thread(web,"汪苏泷").start();
    }
    //票数
    private int ticketNums = 100;
    private boolean flag = true;

    //线程安全同步
    public void test() {
        if(ticketNums<=0) {
            flag = false;
            return;
        }

        //模拟延时，此时会出现数据问题，所以要处理涉及到并发。
        try {
            Thread.sleep(100);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);

    }

    @Override
    public void run() {
        while(flag){
            test();
        }
    }
}
