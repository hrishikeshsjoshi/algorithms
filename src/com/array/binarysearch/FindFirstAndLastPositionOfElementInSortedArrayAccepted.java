package com.array.binarysearch;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8 
 * Output: [3,4] Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6 
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArrayAccepted {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[] {-1, -1};
    updateRange(nums, target, true, result);
    updateRange(nums, target, false, result);
    return result;
  }

  public void updateRange(int[] nums, int target, boolean lower, int[] result) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      // System.out.println(mid);

      if (nums[mid] == target) {
        if (lower) {
          result[0] = mid;
          hi = mid - 1;
        } else {
          // System.out.println(mid);
          result[1] = mid;
          lo = mid + 1;
        }
      } else if (nums[mid] > target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }

    }

  }
}
