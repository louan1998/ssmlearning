package com.wcy.thread;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10,11,12);
        Runable1 able = new Runable1(list);
        Thread t1 = new Thread(able);
        Thread t2 = new Thread(able);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t1.start();
        t2.start();

    }
}
