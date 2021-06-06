package com.array.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * Given a list of non-negative numbers and a target integer k, write a function to check 
 * if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, 
 * that is, sums up to n*k where n is also an integer.
 * 
 * 
 * @formatter:off
 * Input: [23, 2, 6, 4, 7], k=6 
 * Output: True 
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * @formatter:on
 */
public class ContinuousSubarraySumAccepted {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      total += nums[i];
      if (k != 0)
        total %= k;
      Integer prev = map.get(total);
      if (prev != null) {
        //check defaut case 
        if (i - prev > 1) {
          return true;
        }
      } else {
        map.put(total, i);
      }
    }
    return false;
  }

}
