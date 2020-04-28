package com.jt.algo.practice.sword2offer;

/**
 * @description: 面试题56 - I. 数组中数字出现的次数
 * @author: john
 * @created: 2020/04/28 20:59
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 *
 * 时间复杂度是O(N*log(maxValue-minValue))O(N∗log(maxValue−minValue))
 */
public class Sto56 {
    public int[] singleNumbers(int[] nums) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, zeroCount = 0;
        for(int num : nums){
            if(num == 0){
                zeroCount += 1;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum ^= num;
        }

        if(zeroCount == 1){
            return new int[]{sum, 0};
        }

        int low = min, high = max;
        while(low <= high){
            int mid = low < 0 ? low + high >> 1 : low + (high - low) /2;
            int lowSum = 0, highSum = 0;
            for(int num : nums){
                if(num <= mid){
                    lowSum ^= num;
                }else{
                    highSum ^= num;
                }
            }
            if(lowSum != 0 && highSum != 0){
                return new int[]{lowSum, highSum};
            }
            if(lowSum == 0){
                low = mid;
            }else{
                high = mid;
            }
        }
        return null;
    }
}
