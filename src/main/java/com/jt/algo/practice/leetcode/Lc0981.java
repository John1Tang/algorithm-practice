package com.jt.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 981. Time Based Key-Value Store
 * @author: john
 * @created: 2021/08/30 11:47
 *
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the TimeMap class:
 *
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 *  
 *
 * Example 1:
 *
 * Input
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * Output
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 *
 * Explanation
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
 * timeMap.get("foo", 1);         // return "bar"
 * timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
 * timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
 * timeMap.get("foo", 4);         // return "bar2"
 * timeMap.get("foo", 5);         // return "bar2"
 *  
 *
 * Constraints:
 *
 * 1 <= key.length, value.length <= 100
 * key and value consist of lowercase English letters and digits.
 * 1 <= timestamp <= 107
 * All the timestamps timestamp of set are strictly increasing.
 * At most 2 * 105 calls will be made to set and get.
 *
 *
 */
public class Lc0981 {
    class Pair implements Comparable<Pair> {
        int timestamp;
        String value;

        public Pair (int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public int hashCode() {
            return timestamp + value.hashCode();
        }

        public boolean equals (Object obj) {
            if (obj instanceof Pair) {
                Pair pair2 = (Pair) obj;
                return this.timestamp == pair2.timestamp && this.value.equals(pair2.value);
            }
            return false;
        }

        public int compareTo (Pair pair2) {
            if (this.timestamp != pair2.timestamp) {
                return this.timestamp - pair2.timestamp;
            } else {
                return this.value.compareTo(pair2.value);
            }
        }
    }

    Map<String, List<Pair>> map;

    /** Initialize your data structure here. */
//    public TimeMap() {
    public Lc0981() {
        map = new HashMap<String, List<Pair>>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
        pairs.add(new Pair(timestamp, value));
        map.put(key, pairs);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
        Pair pair = new Pair(timestamp, String.valueOf((char) 127) );
        int i = binarySearch(pairs, pair);
        if (i > 0) {
            return pairs.get(i - 1).value;
        }
        return "";
    }
    public int binarySearch(List<Pair> pairs, Pair target) {
        int low  = 0, high = pairs.size() - 1;
        if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            Pair pair = pairs.get(mid);
            if (pair.compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
