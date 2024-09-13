import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        builder(0, 1, k, n, new ArrayList<>());
        return result;
    }

    public void builder(int count, int i, int k, int n, ArrayList<Integer> list) {
        if(count == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        while(i <= n) {
            list.add(i);
            builder(count + 1, i + 1, k, n, list);
            list.removeLast();
            i++;
        }
    }
}
