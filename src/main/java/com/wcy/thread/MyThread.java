package com.wcy.thread;

public class MyThread extends Thread{
    static int ticket = 1000;
    @Override
    public void run() {
        while (true){
            synchronized (MyThread.class){
                if (ticket>0){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket--;
                    System.out.println(getName()+"已售出1张票，还剩"+ticket+"张票！");
                }else {
                    break;
                }

            }

        }
    }
}
