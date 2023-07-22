package com.wcy.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Runable1 implements Runnable{
    ArrayList<Integer> list;

    public Runable1(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            if (extracted()) break;
        }
    }

    private synchronized boolean extracted() {
        if (list.size() == 0){

            return true;
        }else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Collections.shuffle(list);
            int price = list.remove(0);
            System.out.println(Thread.currentThread().getName()+price+"元大奖！");
        }
        return false;
    }
}
