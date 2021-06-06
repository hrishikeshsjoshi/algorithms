package com.string.anagrams;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc". The
 * substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 */
public class FindAllAnagramsInAStringAccepted {

  public static void main(String[] args) {
    FindAllAnagramsInAStringAccepted f = new FindAllAnagramsInAStringAccepted();
    System.out.println(f.findAnagrams("abab", "ab"));
    System.out.println(f.findAnagrams("cbaebabacd", "abc"));
    System.out.println(f.findAnagrams("cbaebacd", "abc"));
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    int distinctCharCount = 0;
    int[] chars = new int[26];
    boolean found[] = new boolean[26];
    /* Find frequency of each char in the shorter string */
    for (int i = 0; i < p.length(); i++) {
      int index = (p.charAt(i) - 'a');
      chars[index]++;
      if (chars[index] == 1) {
        distinctCharCount++;
        found[index] = true;
      }
    }
    int start = 0, end = 0;
    while (end < s.length()) {
      int endIndex = s.charAt(end) - 'a';
      /* Decrement frequency of each character we find */
      if (found[endIndex]) {
        chars[endIndex]--;
        if (chars[endIndex] == 0) {
          distinctCharCount--;
          if (distinctCharCount == 0) {
            result.add(start);
          }
        }
      }
      end++;
      if (end >= p.length()) {
        /* Before incrementing start, update the counters */
        int startIndex = s.charAt(start) - 'a';
        if (found[startIndex]) {
          chars[startIndex]++;
          if (chars[startIndex] == 1) {
            distinctCharCount++;
          }
        }
        start++;
      }
    }
    return result;
  }

}
