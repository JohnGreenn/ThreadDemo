package com.xq.javalib;

/**
 * 线程安全：在并发时保证数据的正确性
 * synchronized
 * 1、同步方法
 * 2、同步块
 *
 */
public class SynTest01 {

    public static void main(String[] args) {
        //一份资源
        SafeWeb12306 web = new SafeWeb12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"周杰伦").start();
        new Thread(web,"许嵩").start();
        new Thread(web,"汪苏泷").start();
    }

    static class SafeWeb12306 implements Runnable {
        //票数
        private int ticketNums = 10;
        private boolean flag = true;

        @Override
        public void run() {
            while(flag) {
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                test();
            }
        }

        //线程安全 同步
        public synchronized void test() {
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
    }

}
