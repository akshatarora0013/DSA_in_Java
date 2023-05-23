package Arrays_Searching_sorting.Questions.LeetCodeHard;

//   https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/description/

public class _1964_Find_the_Longest_Valid_Obstacle_Course_at_Each_Position {
    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            int[] answer = new int[obstacles.length];
            int[] list = new int[obstacles.length];
            int listLength = 0;

            for(int i = 0; i < obstacles.length; i++){
                int height = obstacles[i];
                int index = binarySearch(list, height, listLength);
                if(index == listLength){
                    listLength++;
                }
                list[index] = height;
                answer[i] = index+1;
            }
            return answer;
        }
        private int binarySearch(int[] list, int height, int right){
            if(right == 0){
                return 0;
            }
            int left = 0;
            while(left < right){
                int mid = left + (right - left)/2;
                if(list[mid] <= height){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            return left;
        }
    }
}
