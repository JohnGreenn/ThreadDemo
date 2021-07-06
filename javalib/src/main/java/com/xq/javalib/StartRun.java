package com.xq.javalib;

/**
 * Desc：
 * 1、创建：实现Runna + 重写run
 * 2、启动：创建实现类对象 +Thread对象 +start
 */
public class StartRun implements Runnable{
    /**
     * 线程入口点
     */
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println("shower");
        }
    }

    public static void main(String[] args) {

        new Thread(new StartRun()).start();
        for(int i = 0; i < 20; i++) {
            System.out.println("music");
        }
    }
}
