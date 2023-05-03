package Graph.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/flood-fill/description/

public class _733_Flood_Fill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            boolean[][] visited = new boolean[image.length][image[0].length];
            visited[sr][sc] = true;
            coloring(image, color, sr, sc, visited);
            return image;
        }
        void coloring(int[][] image, int color, int i, int j, boolean[][] visited){
            if(i > 0 && image[i-1][j] == image[i][j] && !visited[i-1][j]){
                visited[i-1][j] = true;
                coloring(image, color, i-1, j, visited);
            }
            if(i < image.length-1 && image[i+1][j] == image[i][j] && !visited[i+1][j]){
                visited[i+1][j] = true;
                coloring(image, color, i+1, j, visited);
            }
            if(j > 0 && image[i][j-1] == image[i][j] && !visited[i][j-1]){
                visited[i][j-1] = true;
                coloring(image, color, i, j-1, visited);
            }
            if(j < image[0].length-1 && image[i][j+1] == image[i][j] && !visited[i][j+1]){
                visited[i][j+1] = true;
                coloring(image, color, i, j+1, visited);
            }
            image[i][j] = color;
        }
    }
}
