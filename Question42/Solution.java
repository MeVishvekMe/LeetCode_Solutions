public class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int[] maxLeftArr = new int[height.length];
        int[] maxRightArr = new int[height.length];
        int[] min = new int[height.length];

        int i = 1;
        while(i < maxLeftArr.length) {
            maxLeftArr[i] = maxLeft;
            if(height[i] > maxLeft) {
                maxLeft = height[i];
            }
            i++;
        }

        i = maxRightArr.length - 2;
        while(i > -1) {
            maxRightArr[i] = maxRight;
            if(height[i] > maxRight) {
                maxRight = height[i];
            }
            i--;
        }

        i = 0;
        while(i < min.length) {
            min[i] = Math.min(maxLeftArr[i], maxRightArr[i]);
            i++;
        }

        i = 0;
        int sum = 0;
        while(i < min.length) {
            int cal = min[i] - height[i];
            if(cal < 0) {
                i++;
                continue;
            }
            sum += cal;
            i++;
        }
        return sum;
    }
}
