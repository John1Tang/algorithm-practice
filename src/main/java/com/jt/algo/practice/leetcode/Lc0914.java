package com.jt.algo.practice.leetcode;

/**
 * @description: 914. X of a Kind in a Deck of Cards
 * @author: john
 * @created: 2020/05/14 23:43
 *
 * In a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 *  
 *
 * Example 1:
 *
 * Input: deck = [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
 * Example 2:
 *
 * Input: deck = [1,1,1,2,2,2,3,3]
 * Output: false´
 * Explanation: No possible partition.
 * Example 3:
 *
 * Input: deck = [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 *
 * Input: deck = [1,1]
 * Output: true
 * Explanation: Possible partition [1,1].
 * Example 5:
 *
 * Input: deck = [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2].
 *
 */
public class Lc0914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for(int c : deck){
            count[c]++;
        }
        int g = -1;
        for(int i = 0; i < 10000; ++i){
            if(count[i] > 0){
                if(g == -1){
                    g = count[i];
                }else{
                    g = gcd(g, count[i]);
                }
            }
        }
        return g >= 2;
    }
    public int gcd(int x, int y){
        return x == 0 ? y : gcd(y % x, x);
    }
}
