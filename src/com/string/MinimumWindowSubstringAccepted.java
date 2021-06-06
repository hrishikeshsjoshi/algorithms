package com.string;

/**
 * 76 https://leetcode.com/problems/minimum-window-substring/description/
 * 
 * @author hrjoshi
 *
 */
public class MinimumWindowSubstringAccepted {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public String minWindow(String s, String t) {
    if (s == null || s.isEmpty() || t == null || t.isEmpty())
      return "";
    int left = 0, right = 0;
    int[] tMap = new int[256];
    int[] sMap = new int[256];
    for (int k = 0; k < t.length(); k++) {
      tMap[t.charAt(k)]++;
    }
    int noOfCharsfound = 0;
    int minLength = Integer.MAX_VALUE;
    String result = "";
    // System.err.println(" tMap"+print(tMap));

    while (right < s.length()) {
      // System.err.println("left = "+left+" right = "+right +"
      // sMap"+print(sMap));
      // System.err.println(" tMap"+print(tMap));

      if (noOfCharsfound < t.length()) {
        if (tMap[s.charAt(right)] > 0) {
          sMap[s.charAt(right)]++;
          // System.err.println("left = "+left+" right = "+right +"
          // sMap"+print(sMap) +" increment " +
          // sMap[s.charAt(right)]);
          if (sMap[s.charAt(right)] <= tMap[s.charAt(right)]) {
            noOfCharsfound++;
          }
        }
        right++;
      }
      while (noOfCharsfound == t.length()) {
        if (right - left < minLength) {
          minLength = right - left;
          result = s.substring(left, right);
        }
        if (tMap[s.charAt(left)] > 0) {
          sMap[s.charAt(left)]--;
          // System.err.println("left = "+left+" right = "+right +"
          // sMap"+print(sMap)+" decrement "+ sMap[s.charAt(left)]);
          if (sMap[s.charAt(left)] < tMap[s.charAt(left)]) {
            noOfCharsfound--;
          }
        }
        left++;
      }
    }
    return result;
  }

}
