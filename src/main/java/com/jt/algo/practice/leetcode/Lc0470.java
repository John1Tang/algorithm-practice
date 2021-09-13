package com.jt.algo.practice.leetcode;

/**
 * @description: 470. Implement Rand10() Using Rand7()
 * @author: john
 * @created: 2021/09/06 22:38
 *
 * Given the API rand7() that generates a uniform random integer in the range [1, 7], write a function rand10() that generates a uniform random integer in the range [1, 10]. You can only call the API rand7(), and you shouldn't call any other API. Please do not use a language's built-in random API.
 *
 * Each test case will have one internal argument n, the number of times that your implemented function rand10() will be called while testing. Note that this is not an argument passed to rand10().
 *
 * Follow up:
 *
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 *  
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: [2]
 * Example 2:
 *
 * Input: n = 2
 * Output: [2,8]
 * Example 3:
 *
 * Input: n = 3
 * Output: [3,8,10]
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 105
 *
 *
 */
public class Lc0470 extends SolBase {
     public int rand10() {
        int a, b, idx;
        while (true) {
            a = rand7();
            b = rand7();
            idx = b + (a - 1) * 7;
            if (idx <= 40) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 40;
            b = rand7();
            // get uniform dist from 1 - 63
            idx = b + (a - 1) * 7;
            if (idx <= 60) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 60;
            b = rand7();
            // get uniform dist from 1 - 21
            idx = b + (a - 1) * 7;
            if (idx <= 20) {
                return 1 + (idx - 1) % 10;
            }
        }
    }
}

class SolBase {
    public int rand7(){
        return 1;
    }
}
