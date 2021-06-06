package com.knapsack;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * Exactly Similar to CoinsKnapsack find combinations without reusing the element.
 *
 */
public class PartitionEqualSubsetSumAccepted {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public boolean canPartition(int[] nums) {
    // sum(Group1) + sum(Group2) = total
    // sum(Group1)=total/2;
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      total += nums[i];
    }
    if (total % 2 != 0)
      return false;
    return find(nums, total / 2);
  }

  public boolean find(int[] nums, int target) {
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;
    for (int num : nums) {
      /* Since we need to use element only once, populate from target to the num */
      for (int i = target; i >= num; i--) {
        dp[i] = dp[i] || dp[i - num];
      }
    }
    return dp[target];
  }

}
