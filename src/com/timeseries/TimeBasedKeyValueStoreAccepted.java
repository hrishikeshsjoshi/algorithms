package com.timeseries;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * TimeBasedKeyValueStoreWithListAccepted solution is better.
 * https://leetcode.com/problems/time-based-key-value-store/
 *
 */
public class TimeBasedKeyValueStoreAccepted {

  /** Initialize your data structure here. */
  public TimeBasedKeyValueStoreAccepted() {
    map = new HashMap<>();
  }

  private Map<String, TreeMap<Integer, String>> map;

  public void set(String key, String value, int timestamp) {
    TreeMap<Integer, String> treeMap = map.get(key);
    if (treeMap == null) {
      treeMap = new TreeMap<>();
      map.put(key, treeMap);
    }
    treeMap.put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> treeMap = map.get(key);
    if (treeMap == null) {
      return "";
    }
    /*
     * floorKey returns the greatest key less than or equal to the given key, or null if there is no
     * such key.
     */
    Integer floor = treeMap.floorKey(timestamp);
    if (floor == null) {
      return "";
    }
    return treeMap.get(floor);
  }

}
