package com.jt.algo.practice.leetcode;

/**
 * @description: 167. Two Sum II - Input array is sorted
 * @author: john
 * @created: 2020/07/20 23:05
 */
public class Lc0167 {
    public int[] twoSum_bi_search(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; ++i){
            int low = i + 1, high = numbers.length - 1;
            while(low <= high){
                int mid = ((high - low) >> 1) + low;
                if(numbers[mid] == target - numbers[i]){
                    return new int[]{i + 1, mid + 1};
                }else if (numbers[mid] > target - numbers[i]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return new int[]{ -1, -1};
    }

    public int[] twoSum_pointer(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low + 1, high + 1};
            }else if(sum < target){
                ++low;
            }else{
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
