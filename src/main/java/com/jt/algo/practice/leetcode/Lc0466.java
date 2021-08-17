package com.jt.algo.practice.leetcode;

/**
 * @description: 466. Count The Repetitions
 * @author: john
 * @created: 2020/04/19 18:25
 *
 * Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
 *
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
 *
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
 *
 * Example:
 *
 * Input:
 * s1="acb", n1=4
 * s2="ab", n2=2
 *
 * Return:
 * 2
 */
public class Lc0466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int index = 0;
        int count = 0;
        if(n1 == 0 || n2 == 0){
            return 0;
        }
        int len1 = s1.length();
        int len2 = s2.length();

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int[] recordCount = new int[n1];
        int[] recordIndex = new int[n1];

        for(int i = 0; i < n1; ++i){
            for(int j =0; j < len1; ++j){
                if(arr1[j] == arr2[index]){
                    ++index;
                }
                if(index == len2){
                    index = 0;
                    ++count;
                }
            }
            recordCount[i] = count;
            recordIndex[i] = index;

            for(int j = 0; j < i; ++j){
                if(recordIndex[j] == index){
                    int before = recordCount[j];
                    int between = count - recordCount[j];
                    int num = (n1 - 1 - j)/(i - j);
                    int betweenAll = num * between;
                    int after = recordCount[j+(n1 - 1 - j) % (i - j)] -before;
                    return (before + betweenAll + after) / n2;
                }
            }
        }
        return recordCount[n1 - 1]/n2;
    }
}
