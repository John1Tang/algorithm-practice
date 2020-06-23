package com.jt.algo.practice.crackinterview;

/**
 * @description: 面试题 16.18. Pattern Matching LCCI
 * @author: john
 * @created: 2020/06/23 08:59
 *
 * You are given two strings, pattern and value. The pattern string consists of just the letters a and b, describing a pattern within a string. For example, the string catcatgocatgo matches the pattern aabab (where cat is a and go is b). It also matches patterns like a, ab, and b. Write a method to determine if value matches pattern. a and b cannot be the same string.
 *
 * Example 1:
 *
 * Input:  pattern = "abba", value = "dogcatcatdog"
 * Output:  true
 * Example 2:
 *
 * Input:  pattern = "abba", value = "dogcatcatfish"
 * Output:  false
 * Example 3:
 *
 * Input:  pattern = "aaaa", value = "dogcatcatdog"
 * Output:  false
 * Example 4:
 *
 * Input:  pattern = "abba", value = "dogdogdogdog"
 * Output:  true
 * Explanation:  "a"="dogdog",b=""，vice versa.
 * Note:
 *
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * pattern only contains "a" and "b", value only contains lowercase letters.
 *
 */
public class Cciv1618 {
    public boolean patternMatching(String pattern, String value) {
        int count_a = 0, count_b = 0;
        for (char ch: pattern.toCharArray()) {
            if (ch == 'a') {
                ++count_a;
            } else {
                ++count_b;
            }
        }
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int len_a = 0; count_a * len_a <= value.length(); ++len_a) {
            int rest = value.length() - count_a * len_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                for (char ch: pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }
}
