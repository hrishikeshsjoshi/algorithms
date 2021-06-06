package com.algo.sort.quickselect;


// kth from largest element
public class KthSmallestElementInAnArray {

  public int findKthLargest(int[] a, int k) {
    int low = 0;
    int high = a.length - 1;
    return findKthHighest(a, low, high, k);
  }

  private int findKthHighest(int[] a, int low, int high, int k) {
    if (a == null || a.length < k) {
      return -1;
    }
    while (low <= high) {
      int pivotIndex = partition(a, low, high);
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

  private int partition(int[] a, int low, int high) {
    swap(a, low, (low + high) / 2);
    int pivotKey = a[low];
    int pivotIndex = low;
    for (int i = low + 1; i <= high; i++) {
      if (a[i] > pivotKey) {
        swap(a, ++pivotIndex, i);
      }
    }
    swap(a, low, pivotIndex);
    return pivotIndex;
  }

  private void swap(int[] a, int pivotIndex, int i) {
    int temp = a[i];
    a[i] = a[pivotIndex];
    a[pivotIndex] = temp;
  }
}
