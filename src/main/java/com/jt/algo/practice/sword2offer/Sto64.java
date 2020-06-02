package com.jt.algo.practice.sword2offer;

/**
 * @description: 面试题64. 求1+2+…+n
 * @author: john
 * @created: 2020/06/02 22:44
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 */
public class Sto64 {

    public int sumNums(int n) {
        return fun(n, n + 1) >> 1;
    }

    int fun(int a,int b){
        int ans = 0;

        if (b == 0) {
            return ans;
        }

        if ((b & 1) != 0) {
            ans = a;
        }
        return ans + fun(a << 1, b >> 1);
    }
}
