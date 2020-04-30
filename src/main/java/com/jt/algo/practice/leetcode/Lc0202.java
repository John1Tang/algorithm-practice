package com.jt.algo.practice.leetcode;

/**
 * @description: 202. Happy Number
 * @author: john
 * @created: 2020/04/30 10:06
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example: 
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
public class Lc0202 {
    public boolean isHappy(int n) {
        int slowPointer = n, fastPointer = getNext(n);
        while(fastPointer != 1 && fastPointer != slowPointer){
            slowPointer = getNext(slowPointer);
            fastPointer = getNext(getNext(fastPointer));
        }
        return fastPointer == 1;
    }

    public int getNext(int n){
        int totalNum = 0;
        while(n > 0){
            int d = n % 10;
            n /= 10;
            totalNum += d * d;
        }
        return totalNum;
    }
}
