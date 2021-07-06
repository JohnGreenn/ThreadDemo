package com.xq.threaddemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/06/30 10:55
 */
public class Alipay {
    private double[] accounts;
    private Lock alipaylock;
    public Alipay(int n, double money) {
        accounts = new double[n];
        alipaylock = new ReentrantLock();
        for(int i = 0; i < accounts.length; i++) {
            accounts[i] = money;
        }
    }

    public void transfer(int from, int to, int amount) {
        alipaylock.lock();
        try{
            while(accounts[from]<amount) {
                //wait
            }

        }finally {
            alipaylock.unlock();
        }
    }
}
