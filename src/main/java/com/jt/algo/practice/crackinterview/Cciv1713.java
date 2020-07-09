package com.jt.algo.practice.crackinterview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 面试题 17.13. Re-Space LCCI
 * @author: john
 * @created: 2020/07/09 23:25
 *
 * Oh, no! You have accidentally removed all spaces, punctuation, and capitalization in a lengthy document. A sentence like "I reset the computer. It still didn't boot!" became "iresetthecomputeritstilldidntboot''. You'll deal with the punctuation and capi­talization later; right now you need to re-insert the spaces. Most of the words are in a dictionary but a few are not. Given a dictionary (a list of strings) and the document (a string), design an algorithm to unconcatenate the document in a way that minimizes the number of unrecognized characters. Return the number of unrecognized characters.
 *
 * Note: This problem is slightly different from the original one in the book.
 *
 *  
 *
 * Example:
 *
 * Input:
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * Output:  7
 * Explanation:  After unconcatenating, we got "jess looked just like tim her brother", which containing 7 unrecognized characters.
 * Note:
 *
 * 0 <= len(sentence) <= 1000
 * The total number of characters in dictionary is less than or equal to 150000.
 * There are only lowercase letters in dictionary and sentence.
 *
 *
 */
public class Cciv1713 {

    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;
    public int respace(String[] dictionary, String sentence) {
        Set<Long> hashValues = new HashSet<>();
        for(String word : dictionary){
            hashValues.add(getHash(word));
        }

        int[] f = new int[sentence.length() + 1];
        Arrays.fill(f, sentence.length());

        f[0] = 0;
        for(int i = 1; i <= sentence.length(); ++i){
            f[i] = f[i - 1] + 1;
            long hashValue = 0;

            for(int j = i; j >= 1; --j){
                int t = sentence.charAt(j - 1) - 'a' + 1;
                hashValue = (hashValue * BASE + t) % P;
                if(hashValues.contains(hashValue)){
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
        }
        return f[sentence.length()];
    }

    public long getHash(String s){
        long hashValue = 0;
        for(int i = s.length() - 1; i >= 0; --i){
            hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
        }
        return hashValue;
    }

}
