package com.knapsack;

/**
 * Find how many combinations can sum to a number
 * 
 *
 */

public class CoinsKnapsack {

  // public static final long[] coins = {2, 3, 4, 1};
  public static final long[] coins = {2, 3, 5};

  // public static final long[] coins = {215, 275, 335, 355,420,580};

  public static void main(String[] args) {
    // List<List<Menu>> findCombinations = findCombinations(menuList, 12.0);
    // System.err.println(findCombinations);
    long findCombinations = findCombinations(8, coins);

    System.err.println(findCombinations);
    // findCombinations = findCombinations(menuList, 6.0);
    // System.err.println(findCombinations);
    //
  }

  private static long findCombinations(long targetLong, long[] coins) {

    int target = (int) targetLong;
    long[] dp = new long[(target + 1)];
    dp[0] = 1;
    // ex target 5, price 2, 3,1,4
    // dp[ 1 0 0 0 0 0 ]
    // for price 2
    // dp [1 0 1 0 0 0 ] at the end of loop from last to 1st
    // for price 3
    // dp [1 0 1 1 0 1 ]
    // for price 4
    // dp [1 0 1 1 1 1]
    // dp [1 1 1 1 1 2]

    for (long coin : coins) {
      int price = (int) (coin);
      for (int i = (int) target; i >= 1; i--) {
        if (i >= price) {
          if (dp[i - price] > 0) {
            dp[i] = dp[i] + dp[i - price];
          }
        }
      }
    }

    return dp[target];
  }

}
