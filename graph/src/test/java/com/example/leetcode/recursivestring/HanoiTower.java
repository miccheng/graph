package com.example.leetcode.recursivestring;

import java.util.List;
import java.util.Stack;


// Sub problem
public class HanoiTower {
    public void towerOfHanoi(int n) {
        // write your code here
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = 1; i <= n; i++) {
            towers[0].add(i);
        }
        moveDisk(towers[0], towers[1], towers[2], n);
    }

    public void moveDisk(Tower start, Tower buffer, Tower destination, int n) {
        if (n<=0) return;
        moveDisk(start, destination, buffer, n - 1);
        moveLast(start, destination);
        moveDisk(buffer, start, destination, n - 1);
    }

    public void moveLast(Tower start, Tower destination) {
        destination.add(start.disks.pop());
    }


    class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {

            } else {
                disks.push(d);
            }
        }
    }


}
