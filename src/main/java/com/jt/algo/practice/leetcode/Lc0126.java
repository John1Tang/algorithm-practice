package com.jt.algo.practice.leetcode;

import java.util.*;

/**
 * @description: 126. Word Ladder II
 * @author: john
 * @created: 2020/06/07 20:33
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 *
 */
public class Lc0126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return ans;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map);

        ArrayList<String> temp = new ArrayList<>();
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, temp, ans);
        return ans;
    }
    private void findLaddersHelper(String beginWord, String endWord,
                                   HashMap<String, ArrayList<String>> map,
                                   ArrayList<String> temp,
                                   List<List<String>> ans){
        if(beginWord.equals(endWord)){
            ans.add(new ArrayList<>(temp));
        }
        ArrayList<String> neighbours = map.getOrDefault(beginWord, new ArrayList<String>());
        for(String neighbour: neighbours){
            temp.add(neighbour);
            findLaddersHelper(neighbour, endWord, map, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, List<String> wordList,
                     HashMap<String, ArrayList<String>> map){
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        bfsHelper(set1, set2, wordSet, true, map);
    }

    private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet,
                              boolean direction, HashMap<String, ArrayList<String>> map){
        if(set1.isEmpty()){
            return false;
        }

        if(set1.size() > set2.size()){
            return bfsHelper(set2, set1, wordSet, !direction, map);
        }
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        boolean done = false;

        Set<String> set = new HashSet<>();
        for(String str : set1){
            for(int i = 0; i < str.length(); i++){
                char[] chars = str.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(chars[i] == ch){
                        continue;
                    }
                    chars[i] = ch;
                    String word = new String(chars);

                    String key = direction ? str : word;
                    String val = direction ? word : str;

                    ArrayList<String> list = map.containsKey(key) ?
                            map.get(key) : new ArrayList<String>();
                    if(set2.contains(word)){
                        done = true;
                        list.add(val);
                        map.put(key, list);
                    }

                    if(!done && wordSet.contains(word)){
                        set.add(word);
                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }
        return done || bfsHelper(set2, set, wordSet, !direction, map);
    }
}
