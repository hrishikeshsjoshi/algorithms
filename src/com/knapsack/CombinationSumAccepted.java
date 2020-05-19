
package com.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 39 https://leetcode.com/problems/combination-sum/description/ Same element could be used multiple
 * times
 * 
 * @author hrjoshi
 *
 */
public class CombinationSumAccepted {

  /**
   * @param args
   */
  public static void main(String[] args) {

    int candidates[] = {2, 3, 6, 7};
    int target = 7;
    // int candidates[] = { 215, 215, 355, 580 };
    // int target = 430;
    System.err.println(new CombinationSumAccepted().combinationSum(candidates, target));

  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<List<Integer>>[] dp = new ArrayList[target + 1];

    dp[0] = new ArrayList<List<Integer>>();
    dp[0].add(new ArrayList<Integer>());

    for (int i = 0; i < candidates.length; i++) {
      int currentCoin = candidates[i];
      if (currentCoin > target) {
        continue;
      }

      // @formatter:off
		/*
		* To reuse elements we should consider from coin till target Ex With coin 2 we
		* can build 2 2+2 2+2+2 2+2+2+2 
		* Now when we have coin 3 2,3,5(2+3),6(2+2+2,3+3),7 (2+2+3), 8(2+2+2+2, 2+3+3)
		*/
		// @formatter:on
      for (int j = currentCoin; j <= target; j++) {

        if (dp[j - currentCoin] != null && dp[j - currentCoin].size() > 0) {
          for (List<Integer> prevList : dp[j - currentCoin]) {
            List<Integer> newList = new ArrayList<>(prevList);
            newList.add(currentCoin);
            if (dp[j] == null) {
              dp[j] = new ArrayList<List<Integer>>();
            }
            dp[j].add(newList);
          }
        }
      }
      System.out.println(Arrays.toString(dp));

    }
    return dp[target] == null ? Collections.emptyList() : dp[target];

  }

}
