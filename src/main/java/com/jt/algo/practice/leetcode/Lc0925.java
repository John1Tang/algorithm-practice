package com.jt.algo.practice.leetcode;

/**
 * @description: 925. Long Pressed Name
 * @author: john
 * @created: 2020/10/21 22:19
 *
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 *  
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 *
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 *
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *  
 *
 * Constraints:
 *
 * 1 <= name.length <= 1000
 * 1 <= typed.length <= 1000
 * The characters of name and typed are lowercase letters.
 *
 *
 */
public class Lc0925 {
    public boolean isLongPressedName(String name, String typed) {
        int namePointer = 0, typePointer = 0;
        while (typePointer < typed.length()) {
            if (namePointer < name.length() && name.charAt(namePointer) == typed.charAt(typePointer)) {
                namePointer++;
                typePointer++;
            } else if (typePointer > 0 && typed.charAt(typePointer) == typed.charAt(typePointer - 1)) {
                typePointer++;
            } else {
                return false;
            }
        }
        return namePointer == name.length();
    }
}
