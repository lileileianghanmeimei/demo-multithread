package com.example.demomultithread.common;

import java.util.concurrent.TimeUnit;

/**
 * 理解中断
 * 首先创建了两个线程，SleepThread和BusyThread，前者不停 地睡眠，后者一直运行，然后对这两个线程分别进行中断操作，观察二者的中断标识位。
 *
 * 从结果可以看出，抛出InterruptedException的线程SleepThread，其中断标识位被清除了， 而一直忙碌运作的线程BusyThread，中断标识位没有被清除。
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
        // sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread"); sleepThread.setDaemon(true);
        // busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread"); busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        // 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        } }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

}
