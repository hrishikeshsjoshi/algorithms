package com.graph.topo;

import java.util.ArrayList;
import java.util.List;

/**
 * @formatter:off
 * Find all nodes which are not part of cycle.
 * 
 * Example:
   Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
                    0     1     2   3   4  5   6
   Here node 0 is connected to 1 and 2
        node 1 is connected to 2 and 3
        node 2 is connected to 5

   Output: [2,4,5,6]
 * @formatter:on
 *
 */
public class FindEventualSafeStatesAccepted {

  public static void main(String[] args) {

  }

  public List<Integer> eventualSafeNodes(int[][] graph) {

    // create a visited, onStack and onCycle array
    boolean[] visited = new boolean[graph.length];
    boolean[] onStack = new boolean[graph.length];
    boolean[] onCycle = new boolean[graph.length];

    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        if (hasCycle(i, graph, visited, onStack, onCycle)) {
          onCycle[i] = true;
        }
      }
      // System.out.println(i+ "-->"+Arrays.toString(onCycle));
    }

    List<Integer> res = new ArrayList<>(visited.length);
    for (int i = 0; i < onCycle.length; i++) {
      if (!onCycle[i]) {
        res.add(i);
      }
    }
    return res;
  }

  public boolean hasCycle(int nodeIndex, int[][] graph, boolean[] visited, boolean[] onStack,
      boolean[] onCycle) {
    // System.out.println(nodeIndex + ", "+onCycle[nodeIndex]);
    // System.out.println(Arrays.toString(onCycle));

    if (onCycle[nodeIndex]) {
      return true;
    }
    visited[nodeIndex] = true;
    onStack[nodeIndex] = true;
    boolean cycle = false;
    for (int neighbor : graph[nodeIndex]) {
      if (onCycle[neighbor]) {
        cycle = true;
        continue;
      }
      if (!visited[neighbor]) {
        if (hasCycle(neighbor, graph, visited, onStack, onCycle)) {
          onCycle[neighbor] = true;
          cycle = true;
        }
      } else {
        if (onStack[neighbor]) {
          onCycle[neighbor] = true;
          cycle = true;
        }
      }
    }
    onStack[nodeIndex] = false;
    return cycle;
  }


  // https://leetcode.com/problems/find-eventual-safe-states/discuss/119871/Straightforward-Java-solution-easy-to-understand!
  public List<Integer> eventualSafeNodes2(int[][] graph) {
    List<Integer> res = new ArrayList<>();
    if (graph == null || graph.length == 0)
      return res;

    int nodeCount = graph.length;
    int[] color = new int[nodeCount];

    for (int i = 0; i < nodeCount; i++) {
      if (dfs(graph, i, color))
        res.add(i);
    }

    return res;
  }

  public boolean dfs(int[][] graph, int start, int[] color) {
    if (color[start] != 0)
      return color[start] == 1;

    color[start] = 2;
    for (int newNode : graph[start]) {
      if (!dfs(graph, newNode, color))
        return false;
    }
    color[start] = 1;

    return true;
  }

}
