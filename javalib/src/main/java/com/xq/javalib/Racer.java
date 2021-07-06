package com.xq.javalib;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/07/01 16:13
 */
public class Racer implements Runnable{
    private static String winner;//胜利者
    @Override
    public void run() {
        for(int steps = 1; steps <= 100; steps++) {
            //兔子偷懒 模拟睡觉
            if(Thread.currentThread().getName().equals("rabbit") && steps%10==0) {
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ "-->" + steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if(flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if(winner!=null) {
            return true;
        } else {
            if(steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println();
                System.out.println("winner==>" + winner);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }
}
