package com.algo.sort.quickselect;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/submissions/
 *
 */
public class KClosestPointsToOriginAccepted {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public int[][] kClosest(int[][] points, int K) {
    int len = points.length, l = 0, r = len - 1;
    while (l <= r) {
      int mid = partition(points, l, r);
      // System.out.println(mid);
      if (mid == K - 1)
        break;
      if (mid < K - 1) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return Arrays.copyOfRange(points, 0, K);
  }

  private int partition(int[][] a, int low, int high) {
    swap(a, low, low + (high - low) / 2);
    int[] pivotKey = a[low];
    int pivotIndex = low;
    // 5, 4 ,3 ,6, 3, 5, 9
    // pivotKey 6
    // 6 4 3 5 3 5 9
    // pivotIndex 0
    // 4 6 3 5 3 5 9
    // pivotIndex 1
    // 4 6 3 5 3 5 9
    // pivotIndex 2
    // 4 3 6 5 3 5 9
    // pivotIndex 3
    // 4 3 5 6 3 5 9

    for (int i = low + 1; i <= high; i++) {
      if (compare(a[i], pivotKey) <= 0) {
        pivotIndex++;
        if (pivotIndex != i) {
          swap(a, pivotIndex, i);
        }
      }
    }
    swap(a, low, pivotIndex);
    return pivotIndex;
  }

  private int compare(int[] p1, int[] p2) {
    return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
  }

  private void swap(int[][] a, int pivotIndex, int i) {

    int[] temp = a[i];
    a[i] = a[pivotIndex];
    a[pivotIndex] = temp;
  }

}
