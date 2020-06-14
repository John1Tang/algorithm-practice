package com.jt.algo.practice.leetcode;

/**
 * @description: 1300. Sum of Mutated Array Closest to Target
 * @author: john
 * @created: 2020/06/15 00:20
 *
 * Given an integer array arr and a target value target, return the integer value such that when we change all the integers larger than value in the given array to be equal to value, the sum of the array gets as close as possible (in absolute difference) to target.
 *
 * In case of a tie, return the minimum such integer.
 *
 * Notice that the answer is not neccesarilly a number from arr.
 *
 *  
 *
 * Example 1:
 *
 * Input: arr = [4,9,3], target = 10
 * Output: 3
 * Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 * Example 2:
 *
 * Input: arr = [2,3,5], target = 10
 * Output: 5
 * Example 3:
 *
 * Input: arr = [60864,25176,27249,21296,20204], target = 56803
 * Output: 11361
 *  
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 *
 */
public class Lc1300 {
    public int findBestValue(int[] arr,int target){

        int sum=0;
        int max_arr=0;
        for (int a: arr) {

            if (a > max_arr) {
                max_arr = a;
            }
            sum+=a;
        }
        if (sum <= target) {
            return max_arr;
        }

        int start=target/arr.length;
        sum=getSum(arr,start);
        if (sum == target) {
            return start;
        }

        //firstSum想要保存的是targetValue的sum
        //secondSum想要保存的是targetValue+1的sum
        int firstSum=sum;
        int secondSum=sum;
        int targetValue=start;
        while(secondSum < target){
            targetValue++;
            firstSum=secondSum;
            secondSum=getSum(arr,targetValue);
            if (secondSum == target) {
                return targetValue;
            }
        }
        if(Math.abs(firstSum-target) > Math.abs(secondSum-target)) {
            return targetValue;
        }else {
            return targetValue-1;
        }
    }

    private int getSum(int[] arr,int senior){
        int sum=0;
        for(int num:arr){
            if (num <= senior) {
                sum += num;
            } else {
                sum += senior;
            }
        }
        return sum;
    }
}
