package Graph.Questions.LeetCodemedium;

import java.util.*;

//   https://leetcode.com/problems/course-schedule/description/

public class _207_Course_Schedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < numCourses; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < prerequisites.length; i++){
                adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }

            int[] inDegree = new int[numCourses];
            for(int i = 0; i < numCourses; i++){
                for(int item: adj.get(i)){
                    inDegree[item]++;
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }

            List<Integer> topo = new ArrayList<>();
            while(!queue.isEmpty()){
                int node = queue.remove();
                topo.add(node);
                for(int item: adj.get(node)){
                    inDegree[item]--;
                    if(inDegree[item] == 0){
                        queue.add(item);
                    }
                }
            }
            if(topo.size() == numCourses){
                return true;
            }
            return false;
        }
    }
}
