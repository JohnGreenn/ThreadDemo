package com.xq.javalib;

/**
 * Desc：
 * 静态代理
 * 公共接口：
 * 1、真实角色
 * 2、代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {

        new HouseAgent(new You()).buyHouse();
        //new Thread(线程对象).start(); 类似
    }
}

//公共接口
interface BuyHouse{
    void buyHouse();
}

//真实角色---你
class You implements BuyHouse{

    @Override
    public void buyHouse() {
        System.out.println("你买到了房子！！！");
    }
}

//代理角色---房产中介

class HouseAgent implements BuyHouse {

    //真实角色
    private BuyHouse target;

    public HouseAgent(BuyHouse target) {
        this.target = target;
    }

    @Override
    public void buyHouse() {
        ready();
        this.target.buyHouse();
        after();
    }


    private void ready() {
        System.out.println("房产中介发布房源");
    }

    private void after() {
        System.out.println("房产中介的房屋售后服务");
    }

}
