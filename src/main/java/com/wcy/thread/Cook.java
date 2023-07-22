package com.wcy.thread;

public class Cook extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if (Desk.foodCount == 0){
                    break;
                }else {
                    if (Desk.foodFlag == 1){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("正在制作");
                        Desk.foodFlag=1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
