package Arrays.Questions.LeetCodeEasy;

import java.util.*;

//  https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/

public class _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {
    class Solution {
        public double average(int[] salary) {
            Arrays.sort(salary);
            double sum = 0;
            int count = 0;
            for(int i = 1; i< salary.length-1; i++){
                sum = sum + salary[i];
                count++;
            }
            return sum/count;
        }
    }
}
