package com.string.palindrome;

public class ValidPalindromeAccepted {

  public static void main(String[] args) {
    ValidPalindromeAccepted vp = new ValidPalindromeAccepted();
    System.err.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    System.err.println(vp.isPalindrome("race a car"));

  }

  public boolean isPalindrome(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }

    for (int i = 0, j = s.length() - 1; i < j;) {
      char ch1 = s.charAt(i);
      if (!Character.isLetterOrDigit(ch1)) {
        i++;
        continue;
      }
      char ch2 = s.charAt(j);
      if (!Character.isLetterOrDigit(ch2)) {
        j--;
        continue;
      }
      ch1 = Character.toLowerCase(ch1);
      ch2 = Character.toLowerCase(ch2);
      if (ch1 != ch2) {
        return false;
      }
      i++;
      j--;
    }
    return true;

  }
}
