package com.elmer.leetcode.guide.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pet {

    int No;
    int count;
    String type;

    public Pet(String type, int No, int count) {
        this.No = No;
        this.count = count;
        this.type = type;
    }
}

public class Main_1_4 {
    // add pollAll pollDog pollCat isEmpty isDogEmpty isCatEmpty
    Queue<Pet> queueCat;
    Queue<Pet> queueDog;
    int count;

    public Main_1_4() {
        queueCat = new LinkedList<>();
        queueDog = new LinkedList<>();
        count = 0;
    }

    public void add(String type, int No) {
        if ("cat".equals(type)) {
            queueCat.add(new Pet(type, No, count));
        } else if ("dog".equals(type)) {
            queueDog.add(new Pet(type, No, count));
        }
        count++;
    }

    public void pollAll() {
        Pet pet;
        while (!queueDog.isEmpty() || !queueCat.isEmpty()) {
            if (queueDog.isEmpty()) {
                pet = queueCat.poll();
            } else if (queueCat.isEmpty()) {
                pet = queueDog.poll();
            } else {
                if (queueCat.peek().count > queueDog.peek().count) {
                    pet = queueDog.poll();
                } else {
                    pet = queueCat.poll();
                }
            }
            System.out.println(pet.type + " " + pet.No);
        }
    }

    public void pollDog() {
        while (!queueDog.isEmpty()) {
            Pet pet = queueDog.poll();
            System.out.println(pet.type + " " + pet.No);
        }
    }

    public void pollCat() {
        while (!queueCat.isEmpty()) {
            Pet pet = queueCat.poll();
            System.out.println(pet.type + " " + pet.No);
        }
    }

    public void isEmpty() {
        if (queueCat.isEmpty() && queueDog.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public void isDogEmpty() {
        if (queueDog.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public void isCatEmpty() {
        if (queueCat.isEmpty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) {
        Main_1_4 main = new Main_1_4();
        Scanner in = new Scanner(System.in);
        int numLine = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numLine; i++) {
            String line = in.nextLine();
            if (line.startsWith("add")) {
                String[] strs = line.split(" ");
                int No = Integer.parseInt(strs[2]);
                main.add(strs[1], No);
            } else if (line.startsWith("pollAll")) {
                main.pollAll();
            } else if (line.startsWith("pollCat")) {
                main.pollCat();
            } else if (line.startsWith("pollDog")) {
                main.pollDog();
            } else if (line.startsWith("isEmpty")) {
                main.isEmpty();
            } else if (line.startsWith("isDogEmpty")) {
                main.isDogEmpty();
            } else if (line.startsWith("isCatEmpty")) {
                main.isCatEmpty();
            } else {
                System.out.println("warning");
            }
        }
    }

}
