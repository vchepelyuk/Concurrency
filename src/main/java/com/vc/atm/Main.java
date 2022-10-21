package com.vc.atm;

public class Main {

    public static void main(String[] args) {
        ATM atm = new ATM(10000);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atm.withdraw("Viktor", 3000);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atm.withdraw("Mark", 5000);
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atm.withdraw("Oleg", 5000);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


