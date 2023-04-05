package com.shijiu.controller;

public class Machine {
    private static int i = 0;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int j = 0; j < 100; j++) {
                i++;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i);

        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
