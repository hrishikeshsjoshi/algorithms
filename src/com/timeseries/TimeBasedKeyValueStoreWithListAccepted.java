package com.timeseries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 *
 */
public class TimeBasedKeyValueStoreWithListAccepted {

  static class TimeValue {

    String value;
    int timestamp;

    public TimeValue(String value, int timestamp) {
      this.value = value;
      this.timestamp = timestamp;
    }
  }

  Map<String, List<TimeValue>> map = new HashMap<>();

  public void set(String key, String value, int timestamp) {
    List<TimeValue> timeValues = map.get(key);
    if (timeValues == null) {
      timeValues = new ArrayList<TimeValue>();
      map.put(key, timeValues);
    }
    timeValues.add(new TimeValue(value, timestamp));
  }

  public String get(String key, int timestamp) {
    List<TimeValue> timeValues = map.get(key);
    if (timeValues == null) {
      return "";
    }
    int index = binarySearch(timeValues, timestamp);
    if (index >= 0 && index <= timeValues.size() - 1) {
      return timeValues.get(index).value;
    }
    return "";

  }

  private int binarySearch(List<TimeValue> timeValues, int timestamp) {
    int low = 0;
    int hi = timeValues.size() - 1;
    int mid = low + (hi - low) / 2;
    while (low <= hi) {
      mid = low + (hi - low) / 2;
      int midTimestamp = timeValues.get(mid).timestamp;
      if (midTimestamp == timestamp) {
        return mid;
      } else if (midTimestamp < timestamp) {
        low = mid + 1;
      } else {
        hi = mid - 1;
      }

    }

    return low - 1;
  }


}
