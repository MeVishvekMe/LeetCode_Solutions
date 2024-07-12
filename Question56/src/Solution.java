import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
    ArrayList<int[]> result = new ArrayList<>();
    int i = 0;
    int min = intervals[0][0];
    int max = intervals[0][1];
    for(int[] itr : intervals) {
      if(itr[0] > max) {
        result.add(new int[]{min, max});
        min = itr[0];
        max = itr[1];
      }
      else {
        if(itr[1] > max) {
          max = itr[1];
        }
      }
    }
    result.add(new int[]{min, max});
    int[][] mergedIntervals = new int[result.size()][2];
    for (int j = 0; j < result.size(); j++) {
      mergedIntervals[j] = result.get(j);
    }
    return mergedIntervals;
  }
}
