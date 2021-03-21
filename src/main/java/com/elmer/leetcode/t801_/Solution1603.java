package com.elmer.leetcode.t801_;

public class Solution1603 {
}

class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        int pos = 0;
        switch (carType) {
            case 1:
                pos = big--;
                break;
            case 2:
                pos = medium--;
                break;
            case 3:
                pos = small--;
                break;
        }
        return pos > 0;
    }
}
