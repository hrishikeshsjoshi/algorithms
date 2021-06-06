package com.algo.sort.quickselect;

import java.util.Arrays;

// kth from largest element
public class KthLargestElementInAnArrayAccepted {

  public static void main(String args[]) {
    KthLargestElementInAnArrayAccepted k1 = new KthLargestElementInAnArrayAccepted();
    int[] a = {5, 2, 4, 6, 3, 5};
    int k = 2;
    // int[] a = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    // int k = 4;
    System.out.println(k1.findKthLargest(a, k));

  }

  /*
   * @formatter:off
   * Input
   *int[] a = {5, 2, 4, 6, 3, 5};
    int k = 2;
    
    Output
    b4 pivotIndex 2 , [5, 2, 4, 6, 3, 5]
    pivotIndex 0 , pivotKey 4 , [4, 2, 5, 6, 3, 5]
    pivotIndex 1 , [4, 5, 2, 6, 3, 5]
    pivotIndex 2 , [4, 5, 6, 2, 3, 5]
    pivotIndex 3 , [4, 5, 6, 5, 3, 2]
    lpivotIndex 3 , [5, 5, 6, 4, 3, 2]
    3, ====== [5, 5, 6, 4, 3, 2]
    b4 pivotIndex 1 , [5, 5, 6, 4, 3, 2]
    pivotIndex 0 , pivotKey 5 , [5, 5, 6, 4, 3, 2]
    pivotIndex 1 , [5, 6, 5, 4, 3, 2]
    lpivotIndex 1 , [6, 5, 5, 4, 3, 2]
    1, ====== [6, 5, 5, 4, 3, 2]
   * 
   * @formatter:on
   */
  public int findKthLargest(int[] a, int k) {
    int low = 0;
    int high = a.length - 1;
    return findKthSmallest(a, low, high, k);
  }

  private int findKthSmallest(int[] a, int low, int high, int k) {
    if (a == null || a.length < k) {
      return -1;
    }
    while (low <= high) {
      int pivotIndex = partition(a, low, high);
      System.out.println(pivotIndex + ", ====== " + Arrays.toString(a));
      if (pivotIndex == k - 1) {
        return a[pivotIndex];
      } else if (pivotIndex > k - 1) {
        high = pivotIndex - 1;
      } else {
        low = pivotIndex + 1;
      }
    }
    return -1;
  }

  private int partition(int[] a, int left, int right) {
    System.out.println("b4 pivotIndex " + (left + (right - left) / 2) + " , " + Arrays.toString(a));
    swap(a, left, left + (right - left) / 2);
    int pivotKey = a[left];
    System.out
        .println("pivotIndex " + left + " , pivotKey " + pivotKey + " , " + Arrays.toString(a));

    int pivotIndex = left;
    for (int i = left + 1; i <= right; i++) {
      if (a[i] > pivotKey) {
        // System.out.println("Swapping " + (pivotIndex + 1) + ", " + i);
        // We can not add condition (i!=pivotIndex+1) as we are incrementing the pivotIndex when
        // a[i]>pivotKey
        swap(a, ++pivotIndex, i);
        System.out.println("pivotIndex " + pivotIndex + " , " + Arrays.toString(a));

      }
    }
    swap(a, left, pivotIndex);
    System.out.println("lpivotIndex " + pivotIndex + " , " + Arrays.toString(a));

    return pivotIndex;
  }

  private void swap(int[] a, int pivotIndex, int i) {
    if (pivotIndex == i) {
      return;
    }
    int temp = a[i];
    a[i] = a[pivotIndex];
    a[pivotIndex] = temp;
  }
}
