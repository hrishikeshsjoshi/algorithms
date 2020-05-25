package com.string.parentheses;

/**
 * Input: s = "lee(t(c)o)de)" Output: "lee(t(c)o)de" Explanation: "lee(t(co)de)" , "lee(t(c)ode)"
 * would also be accepted.
 * 
 * Example 3:
 * 
 * Input: s = "))((" Output: "" Explanation: An empty string is also valid.
 *
 */
public class MinimumRemoveToMakeValidParenthesesAccepted {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public String minRemoveToMakeValid(String s) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '(') {
        count++;
      } else if (s.charAt(i) == ')') {
        count--;
      }

      if (count >= 0) {
        sb.append(s.charAt(i));
      } else {
        count++;
      }
    }

    if (count == 0) {
      return sb.toString();
    }

    // Need to remove extra (
    int i = sb.length() - 1;
    while (count > 0) {
      if (sb.charAt(i) == '(') {
        count--;
        sb.setCharAt(i, '*');
      }
      i--;
    }
    return sb.toString().replaceAll("\\*", "");
  }

}
