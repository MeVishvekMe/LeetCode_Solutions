import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        int sum = ratings.length;
        int i = 1;
        while(i < ratings.length) {
            if(ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
                sum += candies[i] - 1; 
            }
            i++;
        }
        i = ratings.length - 2;
        while(i > -1) {
            if(ratings[i + 1] < ratings[i] && candies[i + 1] >= candies[i]) {
                int newCandyCount = candies[i + 1] + 1;
                sum += newCandyCount - candies[i];
                candies[i] = newCandyCount;
            }
            i--;
        }
        return sum;
    }
}