package com.jt.algo.practice.leetcode;


/**
 * @description: 190. Reverse Bits
 * @author: john
 * @created: 2021/03/29 23:22
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 *  
 *
 * Constraints:
 *
 * The input must be a binary string of length 32
 *
 *
 */
public class Lc0190 {
    // you need treat n as an unsigned value
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public static int reverseBits(Integer n) {
        n = n >>> 1 & M1 | (n & M1) << 1;

        String tmp = Integer.toBinaryString(n);
        int diff = 32 - tmp.length();
        System.out.println("0".repeat(diff) + tmp);

        n = n >>> 2 & M2 | (n & M2) << 2;
        diff = 32 - tmp.length();
        System.out.println("0".repeat(diff) + tmp);

        n = n >>> 4 & M4 | (n & M4) << 4;
        tmp = Integer.toBinaryString(n);
        diff = 32 - tmp.length();
        System.out.println("0".repeat(diff) + tmp);

        n = n >>> 8 & M8 | (n & M8) << 8;
        tmp = Integer.toBinaryString(n);
        diff = 32 - tmp.length();
        System.out.println("0".repeat(diff) + tmp);
        return n >>> 16 | n << 16;
    }

    public static void main(String[] args) {
        //00000010100101000001111010011100
        String ans = Integer.toBinaryString(reverseBits(0x2941e9c));
        int diff = 32 - ans.length();
        System.out.println("outcome");
        System.out.println("0".repeat(diff) + ans);
    }
}
