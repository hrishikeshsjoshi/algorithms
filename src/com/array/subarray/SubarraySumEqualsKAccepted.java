package com.array.subarray;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKAccepted {

  public static void main(String[] args) {
    int[] nums = new int[] {2, 3, 7, 1};
    System.out.println(subarraySum(nums, 11));
  }

  /*
   * Given an array of integers and an integer k, you need to find the total number of continuous
   * subarrays whose sum equals to k. It can contain both positive and negative numbers.
   */
  public static int subarraySum(int[] nums, int k) {

    int sum = 0, result = 0;

    // Sum and frequency of the sum
    Map<Integer, Integer> preSum = new HashMap<>();
    // Frequency of sum 0 is 1
    preSum.put(0, 1);

    // We are looking for continuous sum.
    // Sum of elements between index 2-5 = totalSum - (Sum of elements between 0 to 1)
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (preSum.containsKey(sum - k)) {
        result += preSum.get(sum - k);
      }
      preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
    }

    return result;
  }

}
