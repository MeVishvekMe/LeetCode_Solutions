class Solution {
    public void rotate(int[][] matrix) {
        int min = 0;
        int max = matrix.length - 1;
        int i = 0;

        while(min < max) {
            i = min;
            while(i < max) {
                int first = matrix[min][i];
                int second = matrix[i][max];
                int third = matrix[max][max - (i - min)];
                int fourth = matrix[max - (i - min)][min];
                
                matrix[min][i] = fourth;
                matrix[i][max] = first;
                matrix[max][max - (i - min)] = second;
                matrix[max - (i - min)][min] = third;

                i++;
            }
            
            min++;
            max--;
        }
        
    }
}