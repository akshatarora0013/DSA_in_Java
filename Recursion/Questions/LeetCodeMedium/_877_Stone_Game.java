package Recursion.Questions.LeetCodeMedium;

//  https://leetcode.com/problems/stone-game/

public class _877_Stone_Game {
    class Solution {
        public boolean stoneGame(int[] piles) {
            return count(0, piles.length-1, piles, 0, 0);
        }
        private boolean count(int start, int end, int[] piles, int p1Sum, int p2Sum){
            if(start > end){
                return p1Sum > p2Sum;
            }
            if(piles[start] > piles[end]){
                return count(start+1, end-1, piles, p1Sum+piles[start], p2Sum+piles[end]);
            }
            else{
                return count(start+1, end-1, piles, p1Sum+piles[end], p2Sum+piles[start]);
            }
        }
    }
}
