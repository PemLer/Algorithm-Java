package com.elmer.leetcode.t801_;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution1116 {
}

interface IntConsumer {
    void accept(int x);
}

class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private Semaphore s0 = new Semaphore(1);
    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            s0.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                s1.release();
            } else {
                s2.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            s2.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            s1.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }
}