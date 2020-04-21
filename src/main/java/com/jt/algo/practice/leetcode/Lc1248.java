package com.jt.algo.practice.leetcode;

/**
 * @description: 1248. Count Number of Nice Subarrays
 * @author: john
 * @created: 2020/04/21 22:03
 *
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 */
public class Lc1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, oddCnt = 0, res = 0;
        while(right < nums.length){
            if((nums[right++] & 1) == 1){
                oddCnt++;
            }

            if(oddCnt == k){
                int tmp = right;
                while(right < nums.length && (nums[right] & 1) == 0){
                    right++;
                }
                int rightEvenCnt = right - tmp;

                int leftEvenCnt = 0;
                while((nums[left] & 1) == 0){
                    leftEvenCnt++;
                    left++;
                }

                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);

                left++;
                oddCnt--;
            }
        }
        return res;
    }
}
