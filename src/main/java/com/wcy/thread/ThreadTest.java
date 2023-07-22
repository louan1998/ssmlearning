package com.wcy.thread;

public class ThreadTest {
    public static void main(String[] args) {

//        1.thread启动线程
//        Thread t1 = new MyThread();
//        Thread t2 = new MyThread();
//        Thread t3 = new MyThread();
//
//        t1.setName("窗口1");
//        t2.setName("窗口2");
//        t3.setName("窗口3");
//        t1.start();
//        t2.start();
//        t3.start();

        //2.Runable启动线程
//        Runable1 able = new Runable1();
//        Thread t1 = new Thread(able);
//        Thread t2 = new Thread(able);
//        Thread t3 = new Thread(able);
//
//        t1.setName("窗口1");
//        t2.setName("窗口2");
//        t3.setName("窗口3");
//        t1.start();
//        t2.start();
//        t3.start();

//        3.表达式写法
//        Thread t1 = new Thread(()->{
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            for (int i = 0; i < 5; i++) {
//                System.out.println(1);
//            }
//        });
//        t1.start();
//
//        Thread t2 = new Thread(()->{
//            for (int i = 0; i < 5; i++) {
//                System.out.println(2);
//            }
//        });
//        t2.start();

//        4.生产者消费者事例
        Cook cook = new Cook();
        Eat eat = new Eat();
        cook.setName("厨师");
        eat.setName("顾客");
        cook.start();
        eat.start();
    }
}
