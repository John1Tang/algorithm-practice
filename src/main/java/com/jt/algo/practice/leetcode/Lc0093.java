package com.jt.algo.practice.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 93. Restore IP Addresses
 * @author: john
 * @created: 2020/08/11 20:32
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 *
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 *
 *
 */
public class Lc0093 {

    List<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        int[] segments = new int[4];
        backtrack(s, 0, 0, segments);
        return res;
    }

    public void backtrack(String s, int start, int segmentNum, int[] segments) {

        if (segmentNum == 4) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(segments[i]).append(".");
                }
                sb.append(segments[3]);
                res.add(sb.toString());
            }
            return;
        }

        if (start == s.length()) {
            return;
        }

        if (s.charAt(start) == '0') {
            segments[segmentNum] = 0;
            backtrack(s, start + 1, segmentNum + 1, segments);
        }

        int temp = 0;
        for (int end = start; end < s.length(); end++) {

            temp = temp * 10 + (s.charAt(end) - '0');

            if (temp > 0 && temp <= 255) {
                segments[segmentNum] = temp;
                backtrack(s, end + 1, segmentNum + 1, segments);
            } else {
                break;
            }
        }
    }
}
