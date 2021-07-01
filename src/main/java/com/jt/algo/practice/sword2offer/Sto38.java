package com.jt.algo.practice.sword2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 剑指 Offer 38. 字符串的排列
 * @author: john
 * @created: 2021/06/25 16:26
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 */
public class Sto38 {
    public String[] permutation(String s) {
        List<String> ret = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        do {
            ret.add(new String(arr));
        } while (nextPermutation(arr));

        int size = ret.size();
        String[] retArr = new String[size];
        for (int i = 0; i < size; i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }

    public boolean nextPermutation (char[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = arr.length - 1;
        while (j >= 0 && arr[i] >= arr[j]) {
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    public void swap (char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void reverse (char[] arr, int start) {
        int left = start, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
}
