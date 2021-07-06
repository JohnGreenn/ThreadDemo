package com.xq.javalib;

/**
 * Desc：
 * author：Christiano
 * gitee:
 * time：2021/07/06 14:55
 */
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(123456,1000);
        Drawing you = new Drawing(account,800,"你");
        Drawing girlfriend = new Drawing(account,900,"女友");
        you.start();
        girlfriend.start();
    }

     static class Account {
        int id;// 卡号
        int money;//金额(余额)

        public Account(int id,int money) {
            this.id = id;
            this.money = money;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }

    //模拟取款
    static class Drawing extends Thread {
        Account account;//账号
        int drawingMoney;//取款金额
        int handMoney;//取到手上的钱
        String name;//取款人

        public Drawing(Account account,int drawingMoney, String name) {
            this.account = account;
            this.drawingMoney = drawingMoney;
            this.name = name;
        }

        @Override
        public void run() {
            test();
        }

        public void test(){
            if(account.money<drawingMoney){
                System.out.println("余额不足，无法取钱");
                return;
            }

            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingMoney;
            handMoney += drawingMoney;
            System.out.println(name+"-->账户余额为："+account.money);
            System.out.println(name+"-->手上的钱为："+handMoney);
        }
    }


}
