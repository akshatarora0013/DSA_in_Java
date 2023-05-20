package Arrays.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/maximum-population-year/description/

public class _1854_Maximum_Population_Year {
    class Solution {
        public int maximumPopulation(int[][] logs) {
            int[] population = new int[100];
            for(int[] log: logs){
                for(int i = log[0]-1950; i < log[1]-1950; i++){
                    population[i]++;
                }
            }
            int max = 0;
            for(int i = 1; i < population.length; i++){
                if(population[i] > population[max]){
                    max = i;
                }
            }
            return max+1950;
        }
    }
}
