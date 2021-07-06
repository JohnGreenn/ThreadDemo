package com.xq.javalib;

/**
 * join合并线程，待此线程执行完成后，再执行其他线程，其他线程阻塞
 * Desc：join合并线程，插队线程
 */
public class BlockedJoin02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("爸爸和儿子买烟的故事");
        new Thread(new Father()).start();
    }

     static class Father extends Thread {
        @Override
        public void run() {
            System.out.println("爸爸想抽烟，发现烟没了");
            System.out.println("让儿子去买烟");
            Thread t = new Thread(new Son());
            t.start();

            try {
                t.join();
                System.out.println("老爸拿到了儿子买的烟，开始抽了起来");
            } catch(InterruptedException e) {
                e.printStackTrace();
                System.out.println("儿子一直没回来，老爸忙去寻找");
            }

        }
    }

    static class Son extends Thread {
        @Override
        public void run() {
            System.out.println("接过爸爸的钱去买烟了。。。");
            System.out.println("路边有个游戏厅，玩了10s");
            for(int i = 0; i < 10; i++) {
                System.out.println(i+"秒过去了。。。");
                try {
                    Thread.sleep(1000);

                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("赶紧买烟去。。。");
            System.out.println("手拿一包中华回家了。。。");
        }
    }
}
