package com.jt.algo.practice.leetcode;

/**
 * @description: 215. Kth Largest Element in an Array
 * @author: john
 * @created: 2020/06/29 23:43
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 *
 */
public class Lc0215 {

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for(int i = nums.length - 1; i >= nums.length - k + 1; --i){
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize){
        for(int i = heapSize / 2; i >= 0; --i){
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize){
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if(l < heapSize && a[l] > a[largest]){
            largest = l;
        }
        if(r < heapSize && a[r] > a[largest]){
            largest = r;
        }
        if(largest != i){
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
