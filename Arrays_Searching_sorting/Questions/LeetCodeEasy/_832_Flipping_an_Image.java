package Arrays_Searching_sorting.Questions.LeetCodeEasy;

//  https://leetcode.com/problems/flipping-an-image/

public class _832_Flipping_an_Image {
    class Solution {
        public int[][] flipAndInvertImage(int[][] image) {
            for(int i = 0; i < image.length; i++){
                for(int j = 0; j < image.length / 2; j++){
                    int temp = image[i][j];
                    image[i][j] = image[i][image.length -1 - j];
                    image[i][image.length - 1 - j] = temp;
                }
                for(int j = 0; j < image.length; j++){
                    image[i][j] = 1 - image[i][j];
                }
            }
            return image;
        }
    }
}
