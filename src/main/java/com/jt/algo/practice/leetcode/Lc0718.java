package com.jt.algo.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 718. Maximum Length of Repeated Subarray
 * @author: john
 * @created: 2020/07/01 23:28
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 *  
 *
 * Note:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class Lc0718 {
    int mod = 1_000_000_009;
    int base = 113;

    public int findLength(int[] A, int[] B) {
        int left = 1, right = Math.min(A.length, B.length) + 1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(check(A, B, mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left - 1;
    }

    public boolean check(int[] A, int[] B, int len){
        long hashA = 0;
        for(int i = 0; i < len; i++){
            hashA = (hashA * base + A[i]) % mod;
        }
        Set<Long> bucketA = new HashSet<Long>();
        bucketA.add(hashA);
        long mult = qPow(base, len - 1);

        for(int i = len; i < A.length; i++){
            hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
            bucketA.add(hashA);
        }

        long hashB = 0;
        for(int i = 0; i < len; i++){
            hashB = (hashB * base + B[i]) % mod;
        }

        if(bucketA.contains(hashB)){
            return true;
        }

        for(int i = len; i < B.length; i++){
            hashB = ((hashB - B[i - len] * mult % mod + mod) & mod * base + B[i]) % mod;
            if(bucketA.contains(hashB)){
                return true;
            }
        }
        return false;
    }

    public long qPow(long x, long n){
        long ret = 1;
        while(n != 0){
            if((n & 1) != 0){
                ret = ret * x % mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ret;
    }
}
