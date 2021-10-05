package com.jt.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 166. Fraction to Recurring Decimal
 * @author: john
 * @created: 2021/10/03 21:54
 *
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * If multiple answers are possible, return any of them.
 *
 * It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 *
 *  
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * Example 4:
 *
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 * Example 5:
 *
 * Input: numerator = 1, denominator = 5
 * Output: "0.2"
 *  
 *
 * Constraints:
 *
 * -231 <= numerator, denominator <= 231 - 1
 * denominator != 0
 *
 *
 */
public class Lc0166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuffer sb = new StringBuffer();
        if (numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }

        // integer
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        // fraction
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainerIdxMap = new HashMap<>();
        long remainer = numeratorLong % denominatorLong;
        int index = 0;
        while (remainer != 0 && !remainerIdxMap.containsKey(remainer)) {
            remainerIdxMap.put(remainer, index);
            remainer *= 10;
            fractionPart.append(remainer / denominatorLong);
            remainer %= denominatorLong;
            index++;
        }

        if (remainer != 0) {
            int insertIdx = remainerIdxMap.get(remainer);
            fractionPart.insert(insertIdx, '(');
            fractionPart.append(')');
        }
        sb.append(fractionPart.toString());
        return sb.toString();
    }
}
