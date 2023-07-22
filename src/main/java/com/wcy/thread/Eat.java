package com.wcy.thread;

public class Eat extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if (Desk.foodCount == 0){
                    break;
                }else {
                    if (Desk.foodFlag == 0){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("正在吃，还能在吃"+Desk.foodCount+"碗！");
                        Desk.foodFlag = 0;
                        Desk.foodCount--;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
