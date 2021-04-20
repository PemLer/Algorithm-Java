package com.elmer.leetcode.t801_;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Solution1117 {
}

class H2O {

    public H2O() {
    }

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException, BrokenBarrierException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException, BrokenBarrierException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }
}
