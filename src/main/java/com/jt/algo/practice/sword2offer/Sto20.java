package com.jt.algo.practice.sword2offer;

/**
 * @description: 剑指 Offer 20. 表示数值的字符串
 * @author: john
 * @created: 2020/09/03 20:42
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是
 *
 *
 */
public class Sto20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }

        // 记录 e 和 E 是否存在
        boolean isEExist = false;
        // 记录 小数点 是否存在
        boolean isDotExist = false;
        // 记录 当前数字 是否合法
        boolean numberic = false;
        char[] chars = s.trim().toCharArray();

        for (int index = 0; index < chars.length; index++) {
            char c = chars[index];
            if (c >= '0' && c <= '9') {
                numberic = true;
            } else if (c == '+' || c == '-') {
                // 符号只能出现在 首位 和 E/e紧接之后
                if (index != 0 && chars[index - 1] != 'e' && chars[index - 1] != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (isEExist || isDotExist) {
                    return false;
                }
                isDotExist = true;
            } else if (c == 'E' || c == 'e') {
                // E/e之前必须有数，且没出现过
                if (isEExist || !numberic) {
                    return false;
                }
                isEExist = true;
                numberic = false;
            } else {
                return false;
            }
        }

        return numberic;
    }
}
