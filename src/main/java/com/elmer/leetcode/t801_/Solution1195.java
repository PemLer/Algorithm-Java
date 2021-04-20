package com.elmer.leetcode.t801_;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution1195 {
}

class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    Semaphore s3 = new Semaphore(0);
    Semaphore s5 = new Semaphore(0);
    Semaphore s35 = new Semaphore(0);
    Semaphore sNum = new Semaphore(1);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 == 0) continue;
            s3.acquire();
            printFizz.run();
            sNum.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 == 0) continue;
            s5.acquire();
            printBuzz.run();
            sNum.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            s35.acquire();
            printFizzBuzz.run();
            sNum.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            sNum.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                s35.release();
            } else if (i % 3 == 0) {
                s3.release();
            } else if (i % 5 == 0) {
                s5.release();
            } else {
                printNumber.accept(i);
                sNum.release();
            }
        }
    }
}