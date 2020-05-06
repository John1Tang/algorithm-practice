package com.jt.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description: 460. LFU Cache
 * @author: john
 * @created: 2020/05/06 23:36
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 *
 *  
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *  
 *
 * Example:
 *
 * LFUCache cache = new LFUCache(2);
 *
 *cache.put(1,1);
 *cache.put(2,2);
 *cache.get(1);       // returns 1
 *cache.put(3,3);    // evicts key 2
 *cache.get(2);       // returns -1 (not found)
 *cache.get(3);       // returns 3.
 *cache.put(4,4);    // evicts key 1.
 *cache.get(1);       // returns -1 (not found)
 *cache.get(3);       // returns 3
 *cache.get(4);       // returns 4
 *
 */
public class Lc0460_LFUCache {
    Map<Integer, Node> cache;
    Queue<Node> queue;
    int capacity, size, idx;


    public Lc0460_LFUCache(int capacity) {
        cache = new HashMap<>();
        if(capacity > 0){
            queue = new PriorityQueue<>();
        }
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }
        node.freq++;
        node.idx = idx++;
        queue.remove(node);
        queue.offer(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        Node node = cache.get(key);
        if(node != null){
            node.value = value;
            node.freq++;
            node.idx = idx++;
            queue.remove(node);
            queue.offer(node);
        }else{
            if(size == capacity){
                cache.remove(queue.peek().key);
                queue.poll();
                size--;
            }
            Node newNode = new Node(key, value, idx++);
            cache.put(key, newNode);
            queue.offer(newNode);
            size++;
        }

    }
}
class Node implements Comparable<Node>{
    int key, value, freq, idx;

    public Node(){}

    public Node(int key, int value, int idx){
        this.key = key;
        this.value = value;
        freq = 1;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node node){
        int diff = freq - node.freq;
        return diff != 0 ? diff : idx - node.idx;
    }
}
