import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while(left <= right && top <= bottom) {
            int i = left;
            while(i <= right) {
                result.add(matrix[top][i]);
                i++;
            }
            top++;

            i = top;
            while(i <= bottom) {
                result.add(matrix[i][right]);
                i++;
            }
            right--;

            if(left > right || top > bottom) {
                break;
            }
            i = right;
            while(i >= left) {
                result.add(matrix[bottom][i]);
                i--;
            }
            bottom--;

            i = bottom;
            while(i >= top) {
                result.add(matrix[i][left]);
                i--;
            }
            left++;

        }

        return result;
    }
}