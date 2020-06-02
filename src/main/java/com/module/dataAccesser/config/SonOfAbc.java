package com.module.dataAccesser.config;

public class SonOfAbc extends abcdefg {
    int j = 6;

    static class mythread extends Thread {
        @Override
        public void run() {
            System.out.println("111111111");
        }
    }

    public void print(){
        int i =9;
        System.out.println(i);
    }

    public static void main(String[] args) {
        mythread mythread = new mythread();
        mythread.start();
        mythread.start();

    }
}
