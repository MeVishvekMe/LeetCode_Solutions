import java.util.ArrayList;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        ArrayList<ArrayList<Character>> resultList = new ArrayList<>();
        int i = 0;
        while(i < numRows) {
            resultList.add(new ArrayList<>());
            i++;
        }
        i = 0;
        int idx = 0;
        int dir = 1;
        while(i < s.length()) {
            resultList.get(idx).add(s.charAt(i));
            idx += dir;
            if(idx == numRows) {
                dir = -dir;
                idx = numRows - 2;
            }
            else if(idx == -1) {
                dir = -dir;
                idx = 1;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> list : resultList) {
            for (char c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
