package com.array;

import java.util.Arrays;

public class ProductOfAnArrayExceptSelfAccepted {

  public static void main(String[] args) {
    ProductOfAnArrayExceptSelfAccepted p = new ProductOfAnArrayExceptSelfAccepted();
    int[] nums = {1, 2, 3, 4};
    // int[] nums= {0,0};
    // int[] nums= {1,0};

    System.err.println(Arrays.toString(p.productExceptSelf(nums)));
  }

  public int[] productExceptSelf(int[] nums) {
    int[] tempArr = new int[nums.length];
    int product = 1;
    for (int i = 0; i < nums.length; i++) {
      product = product * nums[i];
      tempArr[i] = product;
    }

    product = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      product = product * nums[i];
      nums[i] = product;
    }

    // 1 2 6 24
    // 24 24 12 4
    // For each position multiply left side with right side
    int temp = 1;
    for (int i = 0; i < nums.length; i++) {
      temp = 1;
      if (i - 1 >= 0) {
        temp = tempArr[i - 1];
      }
      if (i + 1 < nums.length) {
        temp = temp * nums[i + 1];
      }
      nums[i] = temp;
    }

    return nums;

  }

}
