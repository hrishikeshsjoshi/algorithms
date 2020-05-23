package com.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * There are N courses, labelled from 1 to N.
 * 
 * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and
 * course Y: course X has to be studied before course Y.
 * 
 * In one semester you can study any number of courses as long as you have studied all the
 * prerequisites for the course you are studying.
 * 
 * Return the minimum number of semesters needed to study all courses. If there is no way to study
 * all the courses, return -1.
 *
 * 
 * 
 */
public class ParallelCoursesAccepted {

  public static void main(String[] args) {
    int[][] prerequisites = {{2, 3}, {2, 1}, {4, 3}};
    System.err.println("ans =" + new ParallelCoursesAccepted().minimumSemesters(5, prerequisites));
    // int[][] prerequisites = { { 1, 3 }, { 2, 3 } };
    // System.err.println("ans =" + new ParallelCoursesAccepted().minimumSemesters(3,
    // prerequisites));

    // int[][] prerequisites = {{1, 2}, {2, 3}, {3, 1}, {4, 5}};
    // System.err.println("ans =" + new ParallelCoursesAccepted().minimumSemesters(5,
    // prerequisites));
  }

  public int minimumSemesters(int N, int[][] relations) {

    // Build graph using adjacencyList
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    
    //dependencies of each node
    int[] indegree = new int[N + 1];

    for (int i = 0; i < relations.length; i++) {
      int[] relation = relations[i];
      int dependency = relation[0];
      int dependent = relation[1];
      indegree[dependent]++;
      List<Integer> list = adjacencyList.get(dependency);

      if (list == null) {
        list = new ArrayList<Integer>();
        adjacencyList.put(dependency, list);
      }
      list.add(dependent);

    }
    System.out.println(adjacencyList);
    
    // Add nodes to queue which do not depend on anyone 
    // These are seed elements to bfs
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 1; i < indegree.length; i++) {
      int dependency = indegree[i];
      if (dependency == 0) {
        queue.add(i);
      }
    }
    System.out.println("q = " + queue);

    int semester = 0;
    System.out.println(Arrays.toString(indegree));
    int nodesVisited = 0;
    while (!queue.isEmpty()) {
      System.out.println("q = " + queue);

      // run the loop for prev queue size
      for (int i = queue.size() - 1; i >= 0; i--) {
        int preReqCourse = queue.poll();
        nodesVisited++;
        List<Integer> dependents = adjacencyList.remove(preReqCourse);
        if (dependents == null || dependents.isEmpty()) {
          continue;
        }
        //
        for (int j = 0; j < dependents.size(); j++) {
          int course = dependents.get(j);
          if (--indegree[course] == 0) {
            queue.add(course);
          }
        }

      }
      // increase depth by 1
      semester++;
    }
    System.out.println("nodesVisited " + nodesVisited);
    return nodesVisited == N ? semester : -1;

  }

}
