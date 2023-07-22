package com.wcy.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Eat extends Thread{
    ArrayBlockingQueue<String> queue;

    public Eat(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
    }
}
